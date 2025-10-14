package com.example.NoteSpring.Auth.DTO.ResponseSchema;

public class TokenSchema {
    private String token;

    public TokenSchema(){}
    public TokenSchema(String token){
        this.token =token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
