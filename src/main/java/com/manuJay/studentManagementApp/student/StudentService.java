package com.manuJay.studentManagementApp.student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public boolean deleteStudent(int id);

    public boolean updateStudent(int id, Student updatedStudent);

    public Student getStudentById(int id);

}
