package com.example.learnspringboot.controller;

import com.example.learnspringboot.modes.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.learnspringboot.services.BookService;

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook (@PathVariable long id){
        return  ResponseEntity.ok(bookService.getBook(id));
    }


    @GetMapping
    public ResponseEntity<Book[]> getBooks (){
        return ResponseEntity.ok(bookService.getAllBooks()) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook (@PathVariable long id){
        bookService.removeBook(id);
        return new ResponseEntity<>(null , HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> addBook (@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<>(null , HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<Void> updateBook ( @RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<>(null , HttpStatus.NO_CONTENT);
    }


}
