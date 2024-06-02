package com.github.lukaslt1993.courses.student.service;

import java.time.LocalDate;
import java.util.List;

import com.github.lukaslt1993.courses.payment.api.client.PaymentClient;
import com.github.lukaslt1993.courses.payment.api.dto.PaymentDTO;
import com.github.lukaslt1993.courses.student.entity.StudentEntity;
import com.github.lukaslt1993.courses.student.entity.StudentRepository;
import com.github.lukaslt1993.courses.student.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final PaymentClient paymentClient;

    public StudentServiceImpl(StudentRepository studentRepository, PaymentClient paymentClient) {
        this.studentRepository = studentRepository;
        this.paymentClient = paymentClient;
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {
        var savedStudent =  studentRepository.save(student);
        paymentClient.createPayment(
                new PaymentDTO(
                        student.getSchoolName(),
                        student.getPaymentAmount(),
                        savedStudent.getId().toString(),
                        LocalDate.now().toString()
                )
        );
        return savedStudent;
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        StudentEntity existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        if (student.getName() != null) existingStudent.setName(student.getName());
        if (student.getGrade() != null) existingStudent.setGrade(student.getGrade());
        if (student.getMobileNumber() != null) existingStudent.setMobileNumber(student.getMobileNumber());
        if (student.getSchoolName() != null) existingStudent.setSchoolName(student.getSchoolName());
        if (student.getPaymentAmount() != null) existingStudent.setPaymentAmount(student.getPaymentAmount());

        paymentClient.createPayment(
                new PaymentDTO(
                        student.getSchoolName(),
                        student.getPaymentAmount(),
                        existingStudent.getId().toString(),
                        LocalDate.now().toString()
                )
        );

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        StudentEntity existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(existingStudent);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

}
