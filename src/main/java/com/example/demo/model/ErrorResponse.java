package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private int status;

    private List<String> message;

    private LocalDateTime dateTime;

    public ErrorResponse(){
        dateTime = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
