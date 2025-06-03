package com.example.stage1.service;

import com.example.stage1.entity.Student;
import com.example.stage1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository StudentRepository;

    public Student createStudent(Student student){
        return StudentRepository.save(student);
    }
    public List<Student> getAllStudents(){
        return StudentRepository.findAll();
    }
    public  Student getStudentById(Long id){
        return StudentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
    public void updateStudent(Long Id,Student StudentDetails) {
        Student pro=getStudentById(Id);
        pro.setEmail(StudentDetails.getEmail());
        pro.setId(StudentDetails.getId());
        pro.setAge(StudentDetails.getAge());
        pro.setLastname(StudentDetails.getLastname());
        pro.setFirstname(StudentDetails.getFirstname());

        StudentRepository.save(pro);
    }
    public void deleteStudent(Long Id){
        StudentRepository.delete(getStudentById(Id));
    }

}
