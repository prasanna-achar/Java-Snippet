package com.multimediaupload.Service.GlobalExceptionHandler;

import com.multimediaupload.Service.ApiResponseBody.APIResponseBody;
import com.multimediaupload.Service.ApiResponseBody.ApiErrorResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    private static  final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    //Handle Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponseBody> handleValidationException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable :: getDefaultMessage)
                .collect(Collectors.toList());
        String errorMessage =String.join(", ", errors);
        log.warn("Validation Error: {}", errorMessage);

        ApiErrorResponse response = new ApiErrorResponse("Validation Error", errorMessage);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponseBody> handleRuntimeException(RuntimeException ex){
        log.error("Runtime exception occurred: ",ex);
        String msg = ex.getMessage() != null ? ex.getMessage() : "Unexpected Server error";
        ApiErrorResponse response = new ApiErrorResponse("Runtime Exception Occurred", msg);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponseBody> handleException(Exception ex){
        log.error("Runtime exception occurred: ",ex);
        String msg = ex.getMessage() != null ? ex.getMessage() : "Unexpected Server error";
        ApiErrorResponse response = new ApiErrorResponse("Runtime Exception Occurred", msg);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
