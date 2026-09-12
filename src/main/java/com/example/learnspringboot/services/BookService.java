package com.example.learnspringboot.services;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.learnspringboot.dto.BookDTO;
import com.example.learnspringboot.globalExeptions.BookIDNotFoundException;
import com.example.learnspringboot.modes.Book;
import com.example.learnspringboot.repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

 @Autowired
 private BookRepo repository ;

    @Autowired
  private ModelMapper modelMapper ;
 
    public  void addBook (BookDTO bookDTO){
        if(bookDTO.getId() <= 0 || bookDTO.getAuthor() == null || bookDTO.getPrice() <= 0){
            throw new BookIDNotFoundException(bookDTO.getId());
        }

        Book book = modelMapper.map(bookDTO ,Book.class);
        repository.save(book);
    }

    public  void removeBook (long id){
        if(!repository.existsById(id)){
            throw new BookIDNotFoundException(id);
        }
        repository.deleteById(id);

    }

    public  void updateBook (BookDTO bookDTO){
        if(repository.existsById(bookDTO.getId())){
            repository.save(modelMapper.map(bookDTO , Book.class));
        }else{
            throw new BookIDNotFoundException(bookDTO.getId());
        }

    }

    public BookDTO getBook (long id){

        Book book = repository.findById(id).orElseThrow(() -> new BookIDNotFoundException(id));
        return (modelMapper.map(book , BookDTO.class));
    }

    public List <BookDTO> getAllBooks (){

      return repository.findAll().stream()
              .map(book -> modelMapper.map(book , BookDTO.class) )
              .toList();

    }


}
