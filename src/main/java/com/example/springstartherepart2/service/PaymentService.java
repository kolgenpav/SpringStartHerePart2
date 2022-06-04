package com.example.springstartherepart2.service;

import com.example.springstartherepart2.NotEnoughMoneyException;
import com.example.springstartherepart2.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(double amount) {
        if(amount < 1000){
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setAmount(amount);
            return paymentDetails;
        }
        throw new NotEnoughMoneyException();
    }
}
