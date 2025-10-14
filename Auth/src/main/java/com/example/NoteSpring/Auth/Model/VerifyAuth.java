package com.example.NoteSpring.Auth.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class VerifyAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String token;
    private String password;
    private LocalDateTime expiryTime;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;


    public VerifyAuth(){}

    public VerifyAuth(String id, String token, String password, LocalDateTime expiryTime, User user) {
        this.id = id;
        this.token = token;
        this.password = password;
        this.expiryTime = expiryTime;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
