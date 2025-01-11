package com.example.todo_api.service.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import com.example.todo_api.repository.task.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity find() {
        return taskRepository.select()
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new IllegalStateException("TODO")); // TODO
    }
}
