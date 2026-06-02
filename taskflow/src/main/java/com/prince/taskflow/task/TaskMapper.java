package com.prince.taskflow.task;

import com.prince.taskflow.task.dto.TaskResponse;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getAssignedUser() != null ? task.getAssignedUser().getName() : null,
                task.getAssignedUser() != null ? task.getAssignedUser().getEmail() : null,
                task.getProject() != null ? task.getProject().getName() : null
        );
    }
}