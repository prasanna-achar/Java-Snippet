package com.multimediaupload.Service.Controller;


import com.multimediaupload.Service.ApiResponseBody.ApiSuccessResponse;
import com.multimediaupload.Service.ApiResponseBody.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health-check")
public class HealthCheck {

    public ResponseEntity<ResponseBody> healthCheck(){

        ResponseBody response = new ApiSuccessResponse<Object>(HttpStatus.OK, "Server running successfullt",null);
        return new ResponseEntity<ResponseBody>(response, response.getHttpStatus());
    }

}
