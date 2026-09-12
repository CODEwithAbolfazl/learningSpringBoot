package com.example.learnspringboot.controller;

import com.example.learnspringboot.dto.BookDTO;
import com.example.learnspringboot.modes.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.learnspringboot.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook (@PathVariable long id){
        return  ResponseEntity.ok(bookService.getBook(id));
    }


    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks (){
        return ResponseEntity.ok(bookService.getAllBooks()) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook (@PathVariable long id){
        bookService.removeBook(id);
        return new ResponseEntity<>(null , HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> addBook (@RequestBody BookDTO bookDTO){
        bookService.addBook(bookDTO);
        return new ResponseEntity<>(null , HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<Void> updateBook ( @RequestBody BookDTO bookDTO){
        bookService.updateBook(bookDTO);
        return new ResponseEntity<>(null , HttpStatus.NO_CONTENT);
    }


}
