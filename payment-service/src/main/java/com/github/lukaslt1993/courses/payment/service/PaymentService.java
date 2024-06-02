package com.github.lukaslt1993.courses.payment.service;


import com.github.lukaslt1993.courses.payment.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    PaymentEntity savePayment(PaymentEntity payment);

    void deletePayment(Long id);

    List<PaymentEntity> getAllPayments();

    PaymentEntity getPaymentById(Long id);
}
