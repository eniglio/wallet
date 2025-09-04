package com.example.wallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.wallet.model.Wallet;
import com.example.wallet.repository.WalletRepository;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet getWallet(UUID id) {
        return walletRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Wallet deposit(UUID id, BigDecimal amount) {
        Wallet wallet = getWallet(id);
        wallet.setBalance(wallet.getBalance().add(amount));
        return walletRepository.save(wallet);
    }

    @Transactional
    public Wallet withdraw(UUID id, BigDecimal amount) {
        Wallet wallet = getWallet(id);
        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        wallet.setBalance(wallet.getBalance().subtract(amount));
        return walletRepository.save(wallet);
    }

    public void transfer(UUID fromId, UUID toId, BigDecimal amount) {
        if (fromId.equals(toId)) {
            throw new IllegalArgumentException("Conta de origem e destino não podem ser iguais");
        }

        Wallet from = walletRepository.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException("Conta origem não encontrada"));
        Wallet to = walletRepository.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException("Conta destino não encontrada"));

        if (from.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        walletRepository.save(from);
        walletRepository.save(to);
    }
    
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }
}