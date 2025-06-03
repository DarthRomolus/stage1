package com.example.stage1.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Min(value = 0, message = "Age must be a positive number")
    private double age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;




    public void setAge(double age) {
        this.age = age;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public double getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}