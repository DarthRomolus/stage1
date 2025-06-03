package com.example.stage1.controller;

import com.example.stage1.entity.Student;
import com.example.stage1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    StudentService studentService;


    public ResponseEntity<String> check(){
        String students = studentService.getAllStudents().toString();
        return ResponseEntity.ok(students);
    }

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }


}

