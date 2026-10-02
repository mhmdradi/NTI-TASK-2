package org.example.task.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Task {

    private Long id;

    @NotBlank(message = "Title must not be blank.")
    private String title;

    private boolean completed;

    @NotNull(message = "Please choose a priority.")
    private Priority priority;

    public Task() {
    }

    public Task(Long id, String title,
                boolean completed, Priority priority) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}