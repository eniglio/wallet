package com.example.wallet.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionModelTest {

    @Test
    void testTransactionFields() {
        Transaction tx = new Transaction();
        UUID id = UUID.randomUUID();
        tx.setId(id);
        tx.setAmount(BigDecimal.valueOf(50.0));
        assertEquals(id, tx.getId());
        assertEquals(BigDecimal.valueOf(50.0), tx.getAmount());
    }
}
