package org.example.task.service;



import org.example.task.exception.TaskNotFoundException;
import org.example.task.model.Priority;
import org.example.task.model.Task;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public TaskService() {
        create(new Task(
                null, "Learn Spring MVC", false, Priority.HIGH));

        create(new Task(
                null, "Practice JSTL", false, Priority.MEDIUM));

        create(new Task(
                null, "Review Servlets", true, Priority.LOW));
    }

    public List<Task> findAll() {
        return tasks.values()
                .stream()
                .sorted(Comparator.comparing(Task::getId))
                .toList();
    }

    public Task findById(long id) {
        Task task = tasks.get(id);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }

        return task;
    }

    public List<Task> findByPriority(Priority priority) {
        return findAll()
                .stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }

    public Task create(Task form) {
        long id = sequence.incrementAndGet();

        Task saved = new Task(
                id,
                form.getTitle().trim(),
                form.isCompleted(),
                form.getPriority()
        );

        tasks.put(id, saved);
        return saved;
    }
}
