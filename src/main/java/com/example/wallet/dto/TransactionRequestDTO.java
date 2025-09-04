package com.example.wallet.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionRequestDTO {

    private UUID walletId;
    private BigDecimal amount;

    public TransactionRequestDTO() {}

    public TransactionRequestDTO(UUID walletId, BigDecimal amount) {
        this.walletId = walletId;
        this.amount = amount;
    }

    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
