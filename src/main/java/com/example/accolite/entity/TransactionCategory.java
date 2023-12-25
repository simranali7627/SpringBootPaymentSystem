package com.example.accolite.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum  TransactionCategory {
   SUCCESSFUL,
    FAILED,
    FLAGGED
}
