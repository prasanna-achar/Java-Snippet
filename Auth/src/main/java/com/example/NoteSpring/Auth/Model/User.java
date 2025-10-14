package com.example.NoteSpring.Auth.Model;


import com.example.NoteSpring.Auth.Model.Enum.UserRole;
import jakarta.persistence.*;


@Entity
@Table(name = "Auth_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private boolean isVerified;

    public User(){}

    public User(String id, String username, String email, String password, boolean isVerified) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isVerified = isVerified;
        this.userRole = UserRole.USER;
    }
    public User( String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = UserRole.USER;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
