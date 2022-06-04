package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.PaymentDetails;
import com.example.springstartherepart2.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@Controller
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/{amount}")
    public ResponseEntity<?> makePayment(@PathVariable double amount) {
//        try {
        PaymentDetails paymentDetails = paymentService.processPayment(amount);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);

    }

    /*    Exception handling logic moved to ExceptionControllerAdvice
   catch (NotEnoughMoneyException e) {
       ErrorDetails errorDetails = new ErrorDetails();
       errorDetails.setMessage("Not enough money to make the payment");
       return ResponseEntity
               .badRequest()
               .body(errorDetails);
   }
}
*/
    /*We must write amount in the request body in Postman
    * with curl in Windows:
    * curl -X POST http://localhost:8080/payment -H "Content-Type: application/json"
    * -d "{\"amount\": 150.0}" WE NEED ESCAPE QUOTES IN JSON*/
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
        double amountFromRequestBody = paymentDetails.getAmount();
        logger.info("Received payment " + amountFromRequestBody);
        paymentService.processPayment(amountFromRequestBody);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
