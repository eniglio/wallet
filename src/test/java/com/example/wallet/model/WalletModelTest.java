package com.example.wallet.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WalletModelTest {

    @Test
    void testWalletFields() {
        Wallet wallet = new Wallet();
        UUID id = UUID.randomUUID();
        wallet.setId(id);
        wallet.setBalance(BigDecimal.valueOf(100.0));
        assertEquals(id, wallet.getId());
        assertEquals(BigDecimal.valueOf(100.0), wallet.getBalance());
    }
}
