package com.example.springstartherepart2.ch11_openfeign.controller;

import com.example.springstartherepart2.ch11_openfeign.model.Payment;
import com.example.springstartherepart2.ch11_openfeign.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/* Send query to current app:
   curl -X POST http://localhost:8080/ofpayment -H "Content-Type: application/json"
   -d "{\"amount\": 500}"
   in the application.properties of the app: name.service.url = http://localhost:9090
   The PaymentService app have to run at port e.g. 9090
   - in it application.properties: server.port=9090*/
@RestController
public class OpenFeignPaymentsController {
    private final PaymentsProxy paymentsProxy;

    public OpenFeignPaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/ofpayment")
    public Payment createPayment(
            @RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
