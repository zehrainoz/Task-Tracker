package com.dev.tasks.controller;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.dto.CreateTaskRequestDto;
import com.dev.tasks.domain.dto.TaskDto;
import com.dev.tasks.domain.entity.Task;
import com.dev.tasks.mapper.TaskMapper;
import com.dev.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API Controller for Tasks
@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    /**
     * Constructs a new TaskController
     *
     * @param taskService the TaskService dependency
     * @param taskMapper the TaskMapper dependency
     */
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    /**
     * Creates a new Task
     *
     * @param createTaskRequestDto The request DTO used to create a task
     * @return A representation of the created task and an HTTP 201 CREATED.
     */
    @PostMapping
    public ResponseEntity<TaskDto>  createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {

        CreateTaskRequest createdTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createdTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);

        return new  ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }
}
