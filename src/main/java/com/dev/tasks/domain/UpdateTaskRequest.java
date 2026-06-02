package com.dev.tasks.domain;

import com.dev.tasks.domain.entity.TaskPriority;
import com.dev.tasks.domain.entity.TaskStatus;

import java.time.LocalDate;

/**
 * Models a request to update an existing new task.
 *
 * @param title The title of the task
 * @param description The description of the task.
 * @param dueDate The date the task is due
 * @param status The status of the task. Can be null
 * @param priority The priority of the task.
 */
public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority){}
