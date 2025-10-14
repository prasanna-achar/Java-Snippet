package com.example.NoteSpring.Auth.DTO.ResponseSchema;


import com.example.NoteSpring.Auth.Model.Enum.UserRole;

public class UserResponseSchema {
    private String id;
    private String username;
    private String email;
    private boolean verified;
    private UserRole userRole;


    public UserResponseSchema(){}

    public UserResponseSchema(String id, String username, String email, boolean verified, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.verified = verified;
        this.userRole = userRole;
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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
