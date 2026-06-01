package com.prince.taskflow.task;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Spring Data JPA reads the method name and generates the SQL automatically!
    List<Task> findByAssignedUserId(Long userId);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByPriority(TaskPriority priority);
}