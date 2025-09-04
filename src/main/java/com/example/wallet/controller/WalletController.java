package com.example.wallet.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.dto.TransferRequestDTO;
import com.example.wallet.model.Wallet;
import com.example.wallet.service.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @GetMapping("/{id}/balance")
    public BigDecimal getBalance(@PathVariable UUID id) {
        return walletService.getWallet(id).getBalance();
    }

    @PostMapping("/{id}/deposit")
    public Wallet deposit(@PathVariable UUID id, @RequestParam BigDecimal amount) {
        return walletService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Wallet withdraw(@PathVariable UUID id, @RequestParam BigDecimal amount) {
        return walletService.withdraw(id, amount);
    }
    
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequestDTO request) {
        walletService.transfer(request.getFromWalletId(),
                               request.getToWalletId(),
                               request.getAmount());
        return ResponseEntity.ok("Transferência realizada com sucesso");
    }
    
    @GetMapping
    public List<Wallet> list() {
        return walletService.getAllWallets();
    }
}