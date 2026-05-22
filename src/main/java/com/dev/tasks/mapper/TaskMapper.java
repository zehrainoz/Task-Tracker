package com.dev.tasks.mapper;

import com.dev.tasks.domain.CreateTaskRequest;
import com.dev.tasks.domain.dto.CreateTaskRequestDto;
import com.dev.tasks.domain.dto.TaskDto;
import com.dev.tasks.domain.entity.Task;

// Mapper handling Tasks
public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);
    TaskDto toDto(Task task);
}
