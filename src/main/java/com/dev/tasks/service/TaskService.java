package com.dev.tasks.service;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.UpdateTaskRequest;
import com.dev.tasks.domain.entity.Task;

import java.util.List;
import java.util.UUID;

// Service for handling Tasks
public interface TaskService {

    /**
     * Creates a new task
     *
     * @param request The request object used to create the task.
     * @return The created task.
     */
    Task createTask(CreateTaskRequest request);

    /**
     * List tasks
     *
     * @return A list of all tasks
     */
    List<Task> listTasks();

    /**
     * Updates the specified task
     *
     * @param id The ID of the task to update
     * @param request The request object used to update the task.
     * @return The updated task
     */
    Task updateTask(UUID id, UpdateTaskRequest request);
}
