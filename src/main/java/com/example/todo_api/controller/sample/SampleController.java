package com.example.todo_api.controller.sample;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/samples")
public class SampleController {

    //GET /samples
    @GetMapping
    public SampleDTO index() {
        return new SampleDTO("OK", LocalDateTime.now());
    }
}
