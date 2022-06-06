package com.example.springstartherepart2.ch11_resttemplate.proxy;

import com.example.springstartherepart2.ch11_resttemplate.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentsProxy {
    /*Inject RestTemplate*/
    private final RestTemplate rest;
    /*Service base URL from application.properties*/
    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentsProxy(RestTemplate rest) {
        this.rest = rest;
    }

    public Payment createPayment(Payment payment) {
        String uri = paymentServiceUrl + "/payment";
        /*Define Http request headers*/
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());
        /*Define object with request data*/
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
        /*Send request and retrieve data from response*/
        ResponseEntity<Payment> response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
        /*Return response body*/
        return response.getBody();
    }
}
