package org.example.task.controller;


import org.example.task.model.Priority;
import org.example.task.model.Task;
import org.example.task.service.TaskService;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @InitBinder("task")
    public void configureBinding(WebDataBinder binder) {
        binder.setAllowedFields("title", "priority", "completed");
    }

    @ModelAttribute("priorities")
    public Priority[] priorities() {
        return Priority.values();
    }

    // GET /tasks
    @GetMapping
    public String list(Model model) {
        model.addAttribute("tasks", service.findAll());
        model.addAttribute("heading", "All tasks");
        return "tasks/list";
    }

    // GET /tasks/{id}
    @GetMapping("/{id}")
    public String detail(
            @PathVariable("id") long id,
            Model model) {

        model.addAttribute("task", service.findById(id));
        return "tasks/detail";
    }

    // GET /tasks/search?priority=HIGH
    @GetMapping("/search")
    public String search(
            @RequestParam(
                    name = "priority",
                    required = false,
                    defaultValue = "HIGH"
            ) Priority priority,
            Model model) {

        model.addAttribute(
                "tasks", service.findByPriority(priority));

        model.addAttribute(
                "heading", "Tasks with priority " + priority);

        return "tasks/list";
    }

    // GET /tasks/new
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/form";
    }

    // POST /tasks
    @PostMapping
    public String create(
            @Valid @ModelAttribute("task") Task task,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "tasks/form";
        }

        Task saved = service.create(task);

        return "redirect:/tasks/" + saved.getId();
    }
}