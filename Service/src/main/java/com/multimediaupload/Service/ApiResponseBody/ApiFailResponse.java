package com.multimediaupload.Service.ApiResponseBody;

import org.springframework.http.HttpStatus;

public class ApiFailResponse extends APIResponseBody{

    public ApiFailResponse(boolean success, HttpStatus httpStatus, String message) {
        super(success, httpStatus, message);
    }

    public ApiFailResponse(String message){
        super(false, HttpStatus.NOT_ACCEPTABLE, message);
    }
}
