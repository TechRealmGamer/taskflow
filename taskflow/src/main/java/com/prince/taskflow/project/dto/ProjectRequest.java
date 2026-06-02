package com.prince.taskflow.project.dto;

public record ProjectRequest(
        String name,
        String description,
        Long ownerId
) {}