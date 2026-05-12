package com.KK.CrudSpringBootDemo.service;

import com.KK.CrudSpringBootDemo.entity.Student;
import com.KK.CrudSpringBootDemo.repository.StudentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    
    public Student save(Student s){
        return studentRepo.save(s);
    }
    
    public List<Student> getAll(){
        return studentRepo.findAll();
    }
    
    public Student fetchById(int id){
        return studentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    public String remove(int id){
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Entry Deleted";
        }
        else {
            return "Delete failed: Student not found";
        }
    }

    public Student update(int id,Student s){
        Student existing = studentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id : " + id + " not found"));
            existing.setName(s.getName());
            existing.setDept(s.getDept());
        return studentRepo.save(existing);
    }
}
