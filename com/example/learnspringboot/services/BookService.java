package com.example.learnspringboot.services;

import com.example.learnspringboot.globalExeptions.BookIDNotFoundException;
import com.example.learnspringboot.modes.Book;
import org.springframework.stereotype.Service;
import com.example.learnspringboot.repository.BookDB;

@Service
public class BookService {

    private final BookDB dataBase;

    public BookService(){
        dataBase = BookDB.getInstance();
    }



    public  void addBook (Book book){
        dataBase.addBook(book);
    }

    public  void removeBook (long id){
        if(!dataBase.removeBook(id)){
            throw new BookIDNotFoundException(id);
        }

    }

    public  void updateBook (Book book){
        dataBase.updateBook( book);
    }

    public Book getBook (long id){
        return dataBase.getBook(id);
    }

    public Book [] getAllBooks (){
        return dataBase.getAllBooks();
    }


}
