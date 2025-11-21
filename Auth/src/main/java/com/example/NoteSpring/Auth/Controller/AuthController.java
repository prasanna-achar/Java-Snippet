package com.example.NoteSpring.Auth.Controller;

import com.example.NoteSpring.Auth.ApiResponseBody.ResponseBody;
import com.example.NoteSpring.Auth.DTO.RequestSchema.*;

import com.example.NoteSpring.Auth.Service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseBody> register(@RequestBody SignupUser body){
        ResponseBody response = authService.register(body);
        return new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBody> login(@RequestBody LoginUser body){
        ResponseBody response = authService.login(body);
        return new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }
    @PostMapping("/verify/{token}")
    public ResponseEntity<ResponseBody> verify(@PathVariable String token ,@RequestBody GetOTPSchema body, HttpServletResponse res){
        ResponseBody response = authService.verifyUser(token,body.getOTP(), res);
        return new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }
    @GetMapping("/me")
    public ResponseEntity<ResponseBody> getMe(@CookieValue(value = "jwt", required = false) String token){
        ResponseBody response = authService.getMe(token);
        return new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }

    @PostMapping("/resend-otp/{token}")
    public ResponseEntity<ResponseBody> resendOTP(@PathVariable String token){

        ResponseBody response = authService.resendOTP(token);
        return  new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<ResponseBody> forgotPassword(ForgotPasswordSchema body){
        ResponseBody response = authService.forgotPasswordOrChangePassword(body.getEmail());
        return  new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ResponseBody> resetPassword(@PathVariable String token,@RequestBody ResetPasswordSchema body){
        ResponseBody response = authService.resetPassword(token, body.getPassword());
        return  new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }

    // TODO: Change Password
    // TODO: OAuth Important
}
