package com.github.lukaslt1993.courses.payment.api.client;

import com.github.lukaslt1993.courses.payment.api.dto.PaymentDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface PaymentClient {

    @RequestLine("POST /api/payments")
    @Headers("Content-Type: application/json")
    PaymentDTO createPayment(PaymentDTO paymentDTO);

    @RequestLine("DELETE /api/payments/{id}")
    void deletePayment(@Param("id") Long id);

    @RequestLine("GET /api/payments")
    List<PaymentDTO> getAllPayments();

    @RequestLine("GET /api/payments/{id}")
    PaymentDTO getPaymentById(@Param("id") Long id);
}
