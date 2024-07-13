package com.manuJay.studentManagementApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent (@RequestBody Student student){
        studentService.saveStudent(student);
        return "New Student was Added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents (){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        boolean deleted = studentService.deleteStudent(id);
        if(deleted){
            return "The student was successfully deleted";
        }
        else {
            return "The student not found";
        }
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student){
        boolean updated = studentService.updateStudent(id, student);
        if(updated){
            return "Student was updated";
        }
        else {
            return "Student not found";
        }
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

}
