package com.multimediaupload.Service.ApiResponseBody;

import org.springframework.http.HttpStatus;

public class ApiSuccessResponse<type> extends APIResponseBody{
    private type data;

    public ApiSuccessResponse(boolean success, HttpStatus httpStatus, int httpStatusCode, String message, type data) {
        super(success, httpStatus, message);
        this.data = data;
    }


    public ApiSuccessResponse(String message, type data){
        super(true, HttpStatus.OK, message);
        this.data = data;
    }

    public type getData(){
        return data;
    }

    public void setData(type data){
        this.data =data;
    }
}
