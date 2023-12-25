package com.example.accolite.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_table")
public class User {
    @Id
    private int userId;

    private String userName;

    private  String userSecret;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // flag if the user is registered
    private boolean isRegistered;

    // flag if the user opted for offline payment
    private boolean enrolled;
    // flag if the user opted and got approved for offline payment
    private boolean enrolledAndApproved;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;

    Double longitude;

    Double latitude;
    public User(){}
    public User(int userId, String userName, String userSecret, boolean isRegistered, boolean enrolled, boolean enrolledAndApproved, Double longitude, Double latitude) {
        this.userId = userId;
        this.userName = userName;
        this.userSecret = userSecret;
        this.isRegistered = isRegistered;
        this.enrolled = enrolled;
        this.enrolledAndApproved = enrolledAndApproved;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public boolean getUser_enrollapproved() {
        return enrolledAndApproved;
    }

    public void setUser_enrollapproved(boolean user_enrollapproved) {
        this.enrolledAndApproved = user_enrollapproved;
    }

    public Boolean getUser_enrolled() {
        return enrolled;
    }

    public void setUser_enrolled(Boolean user_enrolled) {
        this.enrolled = user_enrolled;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Enumerated(EnumType.STRING)
    private  UserCategory category;

    public UserCategory getCategory() {
        return category;
    }

    public void setCategory(UserCategory category) {
        this.category = category;
    }
    // add the user geolation coordinates

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public boolean isEnrolledAndApproved() {
        return enrolledAndApproved;
    }

    public void setEnrolledAndApproved(boolean enrolledAndApproved) {
        this.enrolledAndApproved = enrolledAndApproved;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSecret='" + userSecret + '\'' +
                ", password='" + password + '\'' +
                ", isRegistered=" + isRegistered +
                ", enrolled=" + enrolled +
                ", enrolledAndApproved=" + enrolledAndApproved +
                ", wallet=" + wallet +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", category=" + category +
                '}';
    }
}
