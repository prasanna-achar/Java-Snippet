package com.example.NoteSpring.Auth.DTO.RequestSchema;

import com.example.NoteSpring.Auth.Model.ResetPassword;

public class ResetPasswordSchema {
    private String password;

    public  ResetPasswordSchema(){}
    public ResetPasswordSchema(String token, String password){
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
