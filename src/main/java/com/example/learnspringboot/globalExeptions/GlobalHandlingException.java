package com.example.learnspringboot.globalExeptions;

import com.example.learnspringboot.dto.ErrorClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlingException {

    @ExceptionHandler(BookIDNotFoundException.class)
    public ResponseEntity<ErrorClass> handleBookIDNotFoundException (BookIDNotFoundException ex){
        ErrorClass error = new ErrorClass(404,"not found");
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
