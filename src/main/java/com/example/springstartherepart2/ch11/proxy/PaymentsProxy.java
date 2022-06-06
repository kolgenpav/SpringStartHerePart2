package com.example.springstartherepart2.ch11.proxy;

import com.example.springstartherepart2.ch11.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/*The name uniquely identifies the client in your app.
The base URI of the request defined by url attribute in application.properties.*/
@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {

    /*Each method you declare in the interface represents a REST endpoint call*/
    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);
}
