package com.salgueiro.paymentservice.service;

import com.salgueiro.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
