package com.example.wallet.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue
    private UUID id;
    private String owner;
    private BigDecimal balance;

    public Wallet() {}

    public Wallet(UUID id, String owner, BigDecimal balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public UUID getId() { 
    	return id; 
    }
    
    public void setId(UUID id) { 
    	this.id = id; 
    }

    public String getOwner() { 
    	return owner; 
    }
    
    public void setOwner(String owner) { 
    	this.owner = owner; 
    }

    public BigDecimal getBalance() { 
    	return balance; 
    }
    
    public void setBalance(BigDecimal balance) { 
    	this.balance = balance; 
    }
}
