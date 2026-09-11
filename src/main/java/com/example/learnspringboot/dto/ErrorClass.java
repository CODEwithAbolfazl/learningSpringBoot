package com.example.learnspringboot.dto;

import java.time.LocalDateTime;

public class ErrorClass {

    private LocalDateTime timeStamp ;
    private int statusCode;
    private  String message;

    public ErrorClass( int statusCode, String message) {
        this.timeStamp = LocalDateTime.now();
        this.statusCode = statusCode;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
