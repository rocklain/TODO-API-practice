package com.example.todo_api.controller.task;

import com.example.todo_api.service.task.TaskEntity;
import com.example.todo_api.service.task.TaskService;
import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.TaskDTO;
import com.example.todoapi.model.TaskForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDTO> showTask(Long taskId) {

        var entity = taskService.find(taskId);

        var dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<TaskDTO> createTask(TaskForm form) {
        var entity =  taskService.create(form.getTitle());

        var dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());

        return ResponseEntity
                .created(URI.create("/tasks/"+dto.getId()))
                .body(dto);
    }

    @Override
    public ResponseEntity<Void> listTasks() {
        return ResponseEntity.ok().build();
    }
}
