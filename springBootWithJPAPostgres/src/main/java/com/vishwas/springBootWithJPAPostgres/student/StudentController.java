package com.vishwas.springBootWithJPAPostgres.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/getStudentList")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent (@RequestBody Student student){
        studentService.addNewStudent (student);
    }
    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{id}")
    public void updateStudent (@PathVariable("id") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob){
        studentService.updateStudent(studentId, name, dob);
    }
}
