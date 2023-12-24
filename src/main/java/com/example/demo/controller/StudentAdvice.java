package com.example.demo.controller;

import com.example.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class StudentAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleExp(MethodArgumentNotValidException exp) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        List<String> msg = new ArrayList<>();
        exp.getBindingResult().getFieldErrors().stream().forEach(
                err -> msg.add("field: " + err.getField() + " msg: " + err.getDefaultMessage()));
        errorResponse.setMessage(msg);
        return ResponseEntity.ok(errorResponse);
    }


}
