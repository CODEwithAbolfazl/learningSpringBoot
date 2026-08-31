package com.example.learnspringboot.globalExeptions;


public class BookIDNotFoundException extends RuntimeException {
    public BookIDNotFoundException(long id) {
        super(id + "Not found");
    }
}
