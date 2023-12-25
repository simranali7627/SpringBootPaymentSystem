package com.example.accolite.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendor_table")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    private String name;
    private Double longitude;

    private Double latitude;

    private Boolean status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_wallet_id")
    private Wallet storeWallet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_wallet_id")
    private Wallet personalWallet;

    public Vendor() {
    }

    public Vendor(Integer vendorId, String name, Double latitude, Double longitude, Boolean status, Wallet storeWallet, Wallet personalWallet) {
        this.vendorId = vendorId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.storeWallet = storeWallet;
        this.personalWallet = personalWallet;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Wallet getStoreWallet() {
        return storeWallet;
    }

    public void setStoreWallet(Wallet storeWallet) {
        this.storeWallet = storeWallet;
    }

    public Wallet getPersonalWallet() {
        return personalWallet;
    }

    public void setPersonalWallet(Wallet personalWallet) {
        this.personalWallet = personalWallet;
    }
}
