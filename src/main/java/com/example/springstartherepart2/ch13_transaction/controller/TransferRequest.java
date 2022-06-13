package com.example.springstartherepart2.ch13_transaction.controller;

import java.math.BigDecimal;

/**
 * Data Transfer Object - DTO. The TransferRequest object simply models
 * the HTTP request body. Such objects, whose responsibility is to model
 * the data transferred between two apps, are DTOs.
 */
public class TransferRequest {
    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;

    public long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
