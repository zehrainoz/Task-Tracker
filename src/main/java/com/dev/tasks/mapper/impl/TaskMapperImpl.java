package com.dev.tasks.mapper.impl;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.UpdateTaskRequest;
import com.dev.tasks.domain.dto.CreateTaskRequestDto;
import com.dev.tasks.domain.dto.TaskDto;
import com.dev.tasks.domain.dto.UpdateTaskRequestDto;
import com.dev.tasks.domain.entity.Task;
import com.dev.tasks.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        if(task == null) return null;

        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus());
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }
}
