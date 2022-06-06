package com.example.springstartherepart2.ch11_openfeign.proxy;

import com.example.springstartherepart2.ch11_openfeign.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Spring creates OpenFeign client that after call to it will call
 * another web app at url=name.service.url and POST and /payment path.
 * It also will send the requestId in header (obtained in PaymentsController)
 * and Payment instance in request body.
 * The name uniquely identifies the client in your app.
 * The base URI of the request defined by url attribute in application.properties.
 */
@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {

    /*Each method you declare in the interface represents a REST endpoint call*/
    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);
}
