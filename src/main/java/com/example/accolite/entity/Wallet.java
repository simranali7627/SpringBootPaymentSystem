package com.example.accolite.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "wallet_table")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long walletId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private  Double walletBalance;

    private Double offlineWalletBalance;
    @ElementCollection
    @CollectionTable(name = "wallet_codes", joinColumns = @JoinColumn(name = "wallet_id"))
    @Column(name = "code")
    @Builder.Default
    private Set<String> codes = new HashSet<>();


    public Wallet() {
        this.setwalletBalance(Double.valueOf(0));
        this.setofflineWalletBalance(Double.valueOf(0));
    }

    public Wallet(int walletId) {
        this.setWalletId(Long.valueOf(walletId));
        this.setwalletBalance(Double.valueOf(0));
        this.setofflineWalletBalance(Double.valueOf(0));
    }

    public Wallet(Long walletId, User user, Double balance, Double offlineBalance) {
        this.walletId = walletId;
        this.user = user;
        this.walletBalance = balance;
        this.offlineWalletBalance = offlineBalance;
    }
    public Wallet(User user) {
        this.user = user;
        this.walletBalance = Double.valueOf(0);
        this.offlineWalletBalance = Double.valueOf(0);
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getwalletBalance() {
        return walletBalance;
    }

    public void setwalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Double getofflineWalletBalance() {
        return offlineWalletBalance;
    }

    public void setofflineWalletBalance(Double offlineWalletBalance) {
        this.offlineWalletBalance = offlineWalletBalance;
    }

    public Set<String> getCodes() {
        return codes;
    }

    public void setCodes(Set<String> codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", user=" + user +
                ", walletBalance=" + walletBalance +
                ", offlineWalletBalance=" + offlineWalletBalance +
                ", codes=" + codes +
                '}';
    }



}
