package com.github.lukaslt1993.courses.student.config;

import com.github.lukaslt1993.courses.payment.api.client.PaymentClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentClientConfiguration {

    @Bean
    public PaymentClient paymentClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(PaymentClient.class, "http://localhost:8081");
    }

}
