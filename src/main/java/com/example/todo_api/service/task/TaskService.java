package com.example.todo_api.service.task;

import com.example.todo_api.controller.task.TaskEntityNotFoundException;
import com.example.todo_api.repository.task.TaskRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import com.example.todo_api.repository.task.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity find(long taskId) {
        return taskRepository.select(taskId)
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new TaskEntityNotFoundException(taskId));
    }

    public List<TaskEntity> find() {
        return List.of(
                new TaskEntity(1,"title_1"),
                new TaskEntity(2,"title_2"));
    }

    public TaskEntity create(String title) {
        var record = new TaskRecord(null, title);
        taskRepository.insert(record);

        return new TaskEntity(record.getId(),record.getTitle());
    }
}
