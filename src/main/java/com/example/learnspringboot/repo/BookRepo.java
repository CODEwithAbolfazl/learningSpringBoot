package com.example.learnspringboot.repo;

import com.example.learnspringboot.modes.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {

    // Find book by title
    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Book findByTitle(String title);

    // Find books by author
    @Query("SELECT b FROM Book b WHERE b.author = ?1")
    List<Book> findByAuthor(String author);

    // Find books cheaper than a price
    @Query("SELECT b FROM Book b WHERE b.price < ?1")
    List<Book> findByPriceLessThan(double price);

    // Find books more expensive than a price
    @Query("SELECT b FROM Book b WHERE b.price > ?1")
    List<Book> findByPriceGreaterThan(double price);

    // Find books by title and author
    @Query("SELECT b FROM Book b WHERE b.title = :title AND b.author = :author")
    List<Book> findByTitleAndAuthor(@Param("title") String title, @Param("author") String author);

    // Find books by title (using LIKE for partial matching)
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> searchByTitleKeyword(@Param("keyword") String keyword);

    // Check if book exists by title
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Book b WHERE b.title = ?1")
    boolean existsByTitle(String title);

}