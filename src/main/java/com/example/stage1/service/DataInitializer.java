package com.example.stage1.service;

import com.example.stage1.entity.Student;
import com.example.stage1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public DataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        // Check if there are already records in the database
        if (studentRepository.count() == 0) {
            // Create and save initial data
            studentRepository.save(new Student(0, "John", "Doe", 21.5, "john.doe@example.com"));
            studentRepository.save(new Student(0, "Jane", "Smith", 22.3, "jane.smith@example.com"));
            studentRepository.save(new Student(0, "Alice", "Johnson", 20.7, "alice.johnson@example.com"));
            studentRepository.save(new Student(0, "Bob", "Brown", 23.1, "bob.brown@example.com"));
            studentRepository.save(new Student(0, "Charlie", "Davis", 22.8, "charlie.davis@example.com"));

            System.out.println("Data initialization completed. Created 5 student records.");
        } else {
            System.out.println("Database already contains records. Skipping initialization.");
        }
    }
}