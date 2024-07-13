package com.manuJay.studentManagementApp.student.impl;

import com.manuJay.studentManagementApp.student.Student;
import com.manuJay.studentManagementApp.student.StudentRepository;
import com.manuJay.studentManagementApp.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    @Override
//    public Boolean deleteStudent(int id) {
//        if(studentRepository.findById(id)!=null) {
//            studentRepository.deleteById(id);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
    @Override
    public boolean deleteStudent(int id)
    {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateStudent(int id , Student updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(updatedStudent.getName());
            student.setAddress(updatedStudent.getAddress());
            studentRepository.save(student);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

}
