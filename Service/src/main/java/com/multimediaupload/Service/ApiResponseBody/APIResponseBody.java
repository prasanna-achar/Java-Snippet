package com.multimediaupload.Service.ApiResponseBody;

import org.springframework.http.HttpStatus;

public abstract class APIResponseBody {

    private boolean success;
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private String message;

    public APIResponseBody(){}

    public APIResponseBody(boolean success, HttpStatus httpStatus,  String message) {
        this.success = success;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.message = message;
    }

    public APIResponseBody(boolean success, HttpStatus httpStatus, int httpStatusCode, String message) {
        this.success = success;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
