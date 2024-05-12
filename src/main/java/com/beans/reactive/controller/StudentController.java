package com.beans.reactive.controller;

import com.beans.reactive.entity.Student;
import com.beans.reactive.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping("/create")
    public Mono<Student> save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping("/find-all")
    public Flux<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(Integer id) {
        return service.findById(id);
    }
}
