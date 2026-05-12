package com.KK.CrudSpringBootDemo.controller;

import com.KK.CrudSpringBootDemo.entity.Student;
import com.KK.CrudSpringBootDemo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService service) {
        studentService = service;
    }

    @PostMapping
    public Student create(@RequestBody Student s) {
        return studentService.save(s);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id) {
        return studentService.fetchById(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student s) {
        return studentService.update(id, s);
    }

    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable int id) {
        return studentService.remove(id);
    }
}
