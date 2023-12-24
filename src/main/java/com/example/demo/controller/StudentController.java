package com.example.demo.controller;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/student")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @PostMapping("/student")
    public ResponseEntity saveStudent(@RequestBody Student student) {
        Student student1 = studentRepo.save(student);
        ResponseEntity<Student> responseEntity = new ResponseEntity<>(student1, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/student")
    public ResponseEntity updateStudent( @Validated @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(student.getId());
        if (optionalStudent.isPresent()) {
            Student student1 = optionalStudent.get();
            if(null != student.getName()) student1.setName(student.getName());
            if(0 != student.getAge()) student1.setAge(student.getAge());
            Student student2 = studentRepo.save(student1);
            return new ResponseEntity<>(student2, HttpStatus.OK);
        } else {
            throw new StudentNotFoundException("Student with id " + student.getId() + " not exists");
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return ResponseEntity.ok("Student with id "+id+" is deleted");
        }
        return new ResponseEntity("Student with id "+id+" not exists",HttpStatus.NOT_FOUND);
    }

}
