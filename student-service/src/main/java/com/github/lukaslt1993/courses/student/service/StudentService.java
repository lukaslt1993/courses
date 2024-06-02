package com.github.lukaslt1993.courses.student.service;

import com.github.lukaslt1993.courses.student.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity saveStudent(StudentEntity student);

    StudentEntity updateStudent(Long id, StudentEntity student);

    void deleteStudent(Long id);

    List<StudentEntity> getAllStudents();

    StudentEntity getStudentById(Long id);
}
