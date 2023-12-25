package com.example.accolite.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transaction_table")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long transactionId;
    private int userId;
    private int vendorId;
    private  Double amount;

    @Enumerated(EnumType.STRING)
    private  TransactionCategory transactionCategory;
    @Enumerated(EnumType.STRING)
    private  PaymentMode paymentMode;

    private Date transactionDate;

    @Version
    private  Long version;

    public Transaction(long transactionId, int userId, int vendorId, Double amount, TransactionCategory transactionCategory, PaymentMode paymentMode, Date transactionDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.vendorId = vendorId;
        this.amount = amount;
        this.transactionCategory = transactionCategory;
        this.paymentMode = paymentMode;
        this.transactionDate = transactionDate;

    }

    public Transaction() {

    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", userId=" + userId +
                ", vendorId=" + vendorId +
                ", amount=" + amount +
                ", transactionCategory=" + transactionCategory +
                ", paymentMode=" + paymentMode +
                ", transactionDate=" + transactionDate +
                ", version=" + version +
                '}';
    }
}
