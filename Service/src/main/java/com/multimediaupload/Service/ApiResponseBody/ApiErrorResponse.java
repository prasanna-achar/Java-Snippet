package com.multimediaupload.Service.ApiResponseBody;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse extends ResponseBody {

    private String error;

    public ApiErrorResponse(String error, String message, HttpStatus httpStatus) {
        super(false, httpStatus, message);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
