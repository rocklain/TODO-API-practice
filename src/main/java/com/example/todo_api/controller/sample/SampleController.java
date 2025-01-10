package com.example.todo_api.controller.sample;

import com.example.todo_api.service.sample.SampleService;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/samples")
public class SampleController {

    private  final SampleService service = new SampleService();

    //GET /samples
    @GetMapping
    public SampleDTO index() {
        var entity = service.find();
        return new SampleDTO(entity.getContent(), LocalDateTime.now());
    }
}
