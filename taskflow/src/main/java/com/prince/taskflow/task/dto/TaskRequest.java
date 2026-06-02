package com.prince.taskflow.task.dto;

import com.prince.taskflow.task.TaskPriority;
import com.prince.taskflow.task.TaskStatus;

public record TaskRequest(
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        Long assignedUserId,
        Long projectId
) {
    // Java records are immutable DTOs — no boilerplate needed
    // Use the full enum path or add imports
}