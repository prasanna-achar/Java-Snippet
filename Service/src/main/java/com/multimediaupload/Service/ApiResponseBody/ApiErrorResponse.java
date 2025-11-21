package com.multimediaupload.Service.ApiResponseBody;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse extends APIResponseBody{
    private String error;

    public ApiErrorResponse(boolean success, HttpStatus httpStatus, String message, String error) {
        super(success, httpStatus, message);
        this.error = error;
    }
    public ApiErrorResponse(String message, String error){
        super(false, HttpStatus.INTERNAL_SERVER_ERROR, message);
        this.error = error;
    }
}
