package com.jorgerosas.student.management.controllers;

import com.jorgerosas.student.management.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsCRUDcontroller {

    private List<Student> students = new ArrayList<Student>(Arrays.asList(
            new Student(1, 20, "Alejandro García", "alejandro.garcia@example.com", "Computer Science"),
            new Student(2, 22, "María López", "maria.lopez@example.com", "Medicine"),
            new Student(3, 19, "Carlos Martínez", "carlos.martinez@example.com", "Law"),
            new Student(4, 21, "Sofía Fernández", "sofia.fernandez@example.com", "Architecture")
    ));

    @GetMapping
    public List<Student> getAllStudents(){return students;}

    @GetMapping("/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        for(Student s : students){
            if(s.getEmail().equals(email)) return s;
        }
        return null;
    }

    @PostMapping
    public void postStudent(@RequestBody Student student){ students.add(student); }

    @PutMapping
    public void putStudent(@RequestBody Student student){
        for(Student s : students){
            if(s.getID() == student.getID()){
                s.setAge(student.getAge());
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setCourse(student.getCourse());
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id){
        for(Student s : students) {
            if (s.getID() == id) students.remove(s);
        }
    }

    @PatchMapping
    public void patchStudent(@RequestBody Student student){
        for(Student s : students){
            if(s.getID() == student.getID()){
                if(student.getAge()!=0){
                    s.setAge(student.getAge());
                }
                if(student.getName()!=null){
                    s.setName(student.getName());
                }
                if(student.getEmail()!=null){
                    s.setEmail(student.getEmail());
                }
                if(student.getCourse()!=null){
                    s.setCourse(student.getCourse());
                }
            }
        }
    }
}