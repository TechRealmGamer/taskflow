package com.prince.taskflow.task;

import com.prince.taskflow.task.dto.TaskRequest;
import com.prince.taskflow.task.dto.TaskResponse;
import com.prince.taskflow.user.User;
import com.prince.taskflow.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    // CREATE
    public TaskResponse createTask(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status() != null ? request.status() : TaskStatus.TODO);
        task.setPriority(request.priority() != null ? request.priority() : TaskPriority.MEDIUM);

        if (request.assignedUserId() != null) {
            User user = userRepository.findById(request.assignedUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            task.setAssignedUser(user);
        }

        return taskMapper.toResponse(taskRepository.save(task));
    }

    // GET ALL
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    // GET BY ID
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        return taskMapper.toResponse(task);
    }

    // GET BY USER
    public List<TaskResponse> getTasksByUser(Long userId) {
        return taskRepository.findByAssignedUserId(userId)
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    // UPDATE
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        if (request.title() != null) task.setTitle(request.title());
        if (request.description() != null) task.setDescription(request.description());
        if (request.status() != null) task.setStatus(request.status());
        if (request.priority() != null) task.setPriority(request.priority());

        if (request.assignedUserId() != null) {
            User user = userRepository.findById(request.assignedUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            task.setAssignedUser(user);
        }

        return taskMapper.toResponse(taskRepository.save(task));
    }

    // DELETE
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }
}