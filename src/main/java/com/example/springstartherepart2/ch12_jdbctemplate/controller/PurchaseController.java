package com.example.springstartherepart2.ch12_jdbctemplate.controller;

import com.example.springstartherepart2.ch12_jdbctemplate.model.Purchase;
import com.example.springstartherepart2.ch12_jdbctemplate.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* curl -X POST http://localhost:8080/purchase -H "Content-Type: application/json"
* -d "{\"product\":\"Spring in Action\", \"price\": 25.2}"
*
* curl http://localhost:8080/purchase
* */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
