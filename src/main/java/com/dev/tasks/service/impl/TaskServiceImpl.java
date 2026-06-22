package com.dev.tasks.service.impl;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.UpdateTaskRequest;
import com.dev.tasks.domain.entity.Task;
import com.dev.tasks.domain.entity.TaskStatus;
import com.dev.tasks.exception.TaskNotFoundException;
import com.dev.tasks.repository.TaskRepository;
import com.dev.tasks.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest request) {
        // Look up the existing task. If it doesn't exist
        // throw a TaskNotFoundException
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        // Update the existing task with the provided information
        existingTask.setTitle(request.title());
        existingTask.setDescription(request.description());
        existingTask.setDueDate(request.dueDate());
        existingTask.setStatus(request.status());
        existingTask.setPriority(request.priority());

        // Update the existing task's updated time value.
        existingTask.setUpdated(Instant.now());

        return taskRepository.save(existingTask);
    }

    @Transactional
    @Override
    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}
