package com.example.learnspringboot.repository;

import com.example.learnspringboot.modes.Book;

import java.util.HashMap;

public class BookDB {
    private static BookDB instance ;
    private HashMap<Long , Book> dataBase ;

    private BookDB (){
        dataBase = new HashMap<>();
    }

    public static synchronized BookDB getInstance(){
        if (instance == null){
            instance = new BookDB();
        }
        return instance;
    }

    public  void addBook (Book book){
        dataBase.put(book.getId() , book);
    }

    public  boolean removeBook (long id){
         return (dataBase.remove(id) != null);
    }

    public  void updateBook (Book book){
        dataBase.replace(book.getId() , book);
    }

    public Book getBook (long id){
        return dataBase.get(id);
    }

    public Book [] getAllBooks (){
        return (dataBase.values()).toArray(new Book[0]);
    }
}
