package com.example.NoteSpring.Auth.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ResetPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String resetPasswordToken;

    private LocalDateTime expiryTime;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public ResetPassword(){}

    public ResetPassword(String id, String resetPasswordToken, User user, LocalDateTime expiryTime) {
        this.id = id;
        this.resetPasswordToken = resetPasswordToken;
        this.user = user;
        this.expiryTime = expiryTime;
    }
    public ResetPassword( String resetPasswordToken, User user, LocalDateTime expiryTime) {
        this.resetPasswordToken = resetPasswordToken;
        this.user = user;
        this.expiryTime = expiryTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
