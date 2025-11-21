package com.multimediaupload.Service.Controllers;


import com.multimediaupload.Service.ApiResponseBody.APIResponseBody;
import com.multimediaupload.Service.ApiResponseBody.ApiSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthCheck {

    @GetMapping
    public ResponseEntity<APIResponseBody> checkHealth(){

        ApiSuccessResponse response = new ApiSuccessResponse("Server Running successfully", null);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
