package com.KK.CrudSpringBootDemo.Controller;

import com.KK.CrudSpringBootDemo.Entity.Student;
import com.KK.CrudSpringBootDemo.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student s){
        return service.save(s);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Student get(@PathVariable int id){
        return service.fetchById(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student s){
        return service.update(id,s);
    }

    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable int id){
        return service.remove(id);
    }
}
