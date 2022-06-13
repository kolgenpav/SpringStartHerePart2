package com.example.springstartherepart2.ch13_transaction.service;

import com.example.springstartherepart2.ch13_transaction.model.Account;
import com.example.springstartherepart2.ch13_transaction.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional   //for all methods
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

//    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);
        BigDecimal senderNewAccount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAccount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idSender, senderNewAccount);
        accountRepository.changeAmount(idReceiver, receiverNewAccount);

        /*Imitation of the problem to check transaction rollback*/
//        throw new RuntimeException("Oh no! Something went wrong!");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
