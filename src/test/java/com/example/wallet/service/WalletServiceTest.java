package com.example.wallet.service;

import com.example.wallet.repository.WalletRepository;
import com.example.wallet.model.Wallet;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletService walletService;

    @Test
    void testGetAllWallets() {
        walletService.getAllWallets();
        verify(walletRepository, times(1)).findAll();
    }
}
