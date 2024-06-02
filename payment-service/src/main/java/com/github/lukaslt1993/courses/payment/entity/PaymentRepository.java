package com.github.lukaslt1993.courses.payment.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> { }

