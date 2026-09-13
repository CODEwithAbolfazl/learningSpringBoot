package com.example.learnspringboot.modes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String author;
    @Column(columnDefinition = "numeric")
    private double price;



    @OneToOne
    @JoinColumn( name = "ISBN_id")
    private ISBN isbn;

    @ManyToOne
    @JoinColumn (name ="author_id" )
    private Author authorInfo;



    @ManyToMany
    @JoinTable ( name = "book_category" ,
    joinColumns =  @JoinColumn (name = "book_id" ),
            inverseJoinColumns = @JoinColumn (name = "category_id" )
    )
    private List<Category> categoryList = new ArrayList<>(); ;


    public Book(Long id, String title, String author, double price, ISBN isbn, Author authorInfo, List<Category> categoryList) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.authorInfo = authorInfo;
        this.categoryList = categoryList;
    }



    public Book() {}

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setAuthorInfo(Author authorInfo) {
        this.authorInfo = authorInfo;
    }

    public Author getAuthorInfo() {
        return authorInfo;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

}
