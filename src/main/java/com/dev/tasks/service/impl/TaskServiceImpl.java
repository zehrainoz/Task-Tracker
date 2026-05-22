package com.dev.tasks.service.impl;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.entity.Task;
import com.dev.tasks.domain.entity.TaskStatus;
import com.dev.tasks.repository.TaskRepository;
import com.dev.tasks.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

// Service for handling Tasks
@Service
public class TaskServiceImpl implements TaskService {

    // The task repository
    private final TaskRepository taskRepository;

    /**
     * Constructs a new TaskServiceImpl using the provided values
     *
     * @param taskRepository The TaskRepository dependency
     */
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {

        // Get the time, date, and timezone right now.
        Instant now = Instant.now();

        // Create a new Task entity
        Task newTask = new Task(
                null, // Hibernate to generate ID for us
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN, // Default to an open status
                request.priority(),
                now,
                now
        );

        // Save the Task, returning the saved Task to the caller
        return taskRepository.save(newTask);
    }
}
