package com.example.learnspringboot.services;

import com.example.learnspringboot.globalExeptions.BookIDNotFoundException;
import com.example.learnspringboot.modes.Book;
import com.example.learnspringboot.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

 @Autowired
 private BookRepo repository ;
 
 
    public  void addBook (Book book){
        repository.save(book);
    }

    public  void removeBook (long id){
        if(!repository.existsById(id)){
            throw new BookIDNotFoundException(id);
        }
        repository.deleteById(id);

    }

    public  void updateBook (Book book){
        if(repository.existsById(book.getId())){
            repository.save( book);
        }else{
            throw new BookIDNotFoundException(book.getId());
        }

    }

    public Book getBook (long id){
        return repository.findById(id).orElse(null);
    }

    public Book [] getAllBooks (){
        return (repository.findAll().toArray(Book[]::new));
    }


}
