package com.example.gsneaker.exceptions;

import com.example.gsneaker.common.MessageKeys;
import com.example.gsneaker.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BaseResponse<Void>> handlerNotFoundException(NotFoundException ex, WebRequest req){
        BaseResponse<Void> response = BaseResponse.<Void>builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseResponse<Void>> handlerConstraintViolationException(ConstraintViolationException ex, WebRequest req){
        BaseResponse<Void> response = BaseResponse.<Void>builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseResponse<Void>> handlerNullPointerException(NullPointerException ex, WebRequest req){
        BaseResponse<Void> response = BaseResponse.<Void>builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseResponse<Void>> handlerException(Exception ex, WebRequest req){
        BaseResponse<Void> response = BaseResponse.<Void>builder()
                .success(false)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(MessageKeys.INTERNAL_SERVER_ERROR)
                .build();
        log.error("An error occurred", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
