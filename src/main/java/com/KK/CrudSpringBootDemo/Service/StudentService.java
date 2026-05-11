package com.KK.CrudSpringBootDemo.Service;

import com.KK.CrudSpringBootDemo.Entity.Student;
import com.KK.CrudSpringBootDemo.Repository.StudentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;
    
    public Student save(Student s){
        return repo.save(s);
    }
    
    public List<Student> getAll(){
        return repo.findAll();
    }
    
    public Student fetchById(int id){
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    public String remove(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Entry Deleted";
        }
        else {
            return "Delete faild: Student not found";
        }
    }

    public Student update(int id,Student s){
        Student existing = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id : " + id + " not found"));
            existing.setName(s.getName());
            existing.setDept(s.getDept());
        return repo.save(existing);
    }
}
