package com.example.springstartherepart2.ch13_transaction.controller;

import com.example.springstartherepart2.ch13_transaction.model.Account;
import com.example.springstartherepart2.ch13_transaction.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
curl http://localhost:8080/accounts

curl -X POST http://localhost:8080/transfer -H "Content-Type: application/json"
-d "{\"senderAccountId\":1, \"receiverAccountId\":2, \"amount\":100}"
 */
@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(request.getSenderAccountId(),
                request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }
}
