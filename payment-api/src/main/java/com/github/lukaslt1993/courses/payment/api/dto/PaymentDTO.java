package com.github.lukaslt1993.courses.payment.api.dto;

import java.math.BigDecimal;

public class PaymentDTO {
    private String schoolName;
    private BigDecimal amount;
    private String studentId;
    private String paymentDate;

    public PaymentDTO(String schoolName, BigDecimal amount, String studentId, String paymentDate) {
        this.schoolName = schoolName;
        this.amount = amount;
        this.studentId = studentId;
        this.paymentDate = paymentDate;
    }

    public PaymentDTO() {

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
