package com.dev.tasks.controller;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.UpdateTaskRequest;
import com.dev.tasks.domain.dto.CreateTaskRequestDto;
import com.dev.tasks.domain.dto.TaskDto;
import com.dev.tasks.domain.dto.UpdateTaskRequestDto;
import com.dev.tasks.domain.entity.Task;
import com.dev.tasks.mapper.TaskMapper;
import com.dev.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    /**
     * List all tasks with an HTTP 200 ok
     *
     * @return The list of tasks.
     */
    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks() {
        List<Task> tasks = taskService.listTasks();

        // Map the list of Task objects to a list of TaskDto objects.
        List<TaskDto> taskDtoList = tasks.stream()
                .map(taskMapper::toDto)
                .toList();

        return ResponseEntity.ok(taskDtoList);
    }

    /**
     * Updates the specified task with the provided information.
     *
     * @param id The ID of the task to update
     * @param updateTaskRequestDto The request DTO used to update the task
     * @return A representation of the updated task with an HTTP 200
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto){

        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task updatedTask = taskService.updateTask(id, updateTaskRequest);
        TaskDto updatedTaskDto = taskMapper.toDto(updatedTask);

        return ResponseEntity.ok(updatedTaskDto);
    }
}
