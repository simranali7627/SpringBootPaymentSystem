package com.example.accolite.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;




    private String password;


    // flag if the user is registered
    private boolean isRegistered;

    // flag if the user opted for offline payment
    private boolean enrolled;
    // flag if the user opted and got approved for offline payment
    private boolean enrolledAndApproved;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;
    @Enumerated(EnumType.STRING)
    private  UserCategory category;

    public User() {

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int userId, String userName,  boolean isRegistered, boolean enrolled, boolean enrolledAndApproved) {
        this.userId = userId;
        this.userName = userName;
        this.isRegistered = isRegistered;
        this.enrolled = enrolled;
        this.enrolledAndApproved = enrolledAndApproved;

    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }







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



    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +

                ", password='" + password + '\'' +
                ", isRegistered=" + isRegistered +
                ", enrolled=" + enrolled +
                ", enrolledAndApproved=" + enrolledAndApproved +
                ", wallet=" + wallet +
                ", category=" + category +
                '}';
    }
}
