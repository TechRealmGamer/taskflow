package com.prince.taskflow.task.dto;

import com.prince.taskflow.task.TaskPriority;
import com.prince.taskflow.task.TaskStatus;
import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String assignedUserName,   // just the name, not the whole User object
        String assignedUserEmail
) {}