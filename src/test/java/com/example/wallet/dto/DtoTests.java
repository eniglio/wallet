package com.example.wallet.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoTests {

    @Test
    void testWalletDto() {
        UUID id = UUID.randomUUID();
        WalletDTO dto = new WalletDTO(id, "Test Wallet", BigDecimal.TEN);
        assertEquals(id, dto.getId());
        assertEquals("Test Wallet", dto.getName());
        assertEquals(BigDecimal.TEN, dto.getBalance());
    }

    @Test
    void testTransactionDto() {
        UUID id = UUID.randomUUID();
        UUID walletId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        TransactionDTO dto = new TransactionDTO(id, walletId, "DEPOSIT", BigDecimal.ONE, now);
        assertEquals(id, dto.getId());
        assertEquals(walletId, dto.getWalletId());
        assertEquals("DEPOSIT", dto.getType());
        assertEquals(BigDecimal.ONE, dto.getAmount());
        assertEquals(now, dto.getTimestamp());
    }

    @Test
    void testTransactionRequestDto() {
        UUID walletId = UUID.randomUUID();
        TransactionRequestDTO dto = new TransactionRequestDTO(walletId, BigDecimal.valueOf(30.0));
        assertEquals(walletId, dto.getWalletId());
        assertEquals(BigDecimal.valueOf(30.0), dto.getAmount());
    }

    @Test
    void testTransferRequestDto() {
        UUID fromWalletId = UUID.randomUUID();
        UUID toWalletId = UUID.randomUUID();
        TransferRequestDTO dto = new TransferRequestDTO(fromWalletId, toWalletId, BigDecimal.valueOf(40.0));
        assertEquals(fromWalletId, dto.getFromWalletId());
        assertEquals(toWalletId, dto.getToWalletId());
        assertEquals(BigDecimal.valueOf(40.0), dto.getAmount());
    }
}
