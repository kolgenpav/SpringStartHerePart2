package com.example.springstartherepart2.ch11_resttemplate.controller;

import com.example.springstartherepart2.ch11_resttemplate.model.Payment;
import com.example.springstartherepart2.ch11_resttemplate.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* Send query to current app:
   curl -X POST http://localhost:8080/rtpayment -H "Content-Type: application/json"
   -d "{\"amount\": 500}"
   in the application.properties of the app: name.service.url = http://localhost:9090
   The PaymentService app have to run at port e.g. 9090
   - in it application.properties: server.port=9090*/
@RestController
public class RestTemplatePaymentsController {
    private final PaymentsProxy paymentsProxy;

    public RestTemplatePaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/rtpayment")
    public Payment createPayment(@RequestBody Payment payment){
        return paymentsProxy.createPayment(payment);
    }
}
