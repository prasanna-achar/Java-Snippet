package com.multimediaupload.Service.ExceptionHandler;
import com.multimediaupload.Service.ApiResponseBody.ApiErrorResponse;
import com.multimediaupload.Service.ApiResponseBody.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 1️⃣ Handle validation errors (like @Valid failures)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBody> handleValidationException(MethodArgumentNotValidException ex) {
        // Collect all validation error messages
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        String errorMessage = String.join(", ", errors);
        log.warn("Validation error: {}", errorMessage);

        ApiErrorResponse response = new ApiErrorResponse("Validation Error", errorMessage, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 2️⃣ Handle custom business exceptions


    // 3️⃣ Handle generic runtime exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseBody> handleRuntimeException(RuntimeException ex) {
        log.error("Runtime exception occurred", ex);
        String msg = ex.getMessage() != null ? ex.getMessage() : "Unexpected server error";
        ApiErrorResponse response = new ApiErrorResponse(ex.getClass().getSimpleName(), msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 4️⃣ Catch-all for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBody> handleException(Exception ex) {
        log.error("Unhandled exception occurred", ex);
        String msg = ex.getMessage() != null ? ex.getMessage() : "Unexpected server error";
        ApiErrorResponse response = new ApiErrorResponse("Exception", msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
