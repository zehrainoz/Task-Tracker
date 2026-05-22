package com.dev.tasks.service;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.entity.Task;

// Service for handling Tasks
public interface TaskService {

    /**
     * Creates a new task
     *
     * @param request The request object used to create the task.
     * @return The created task.
     */
    Task createTask(CreateTaskRequest request);
}
