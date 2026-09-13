package com.example.learnspringboot.modes;

import jakarta.persistence.*;

@Entity
@Table(name = "ISBN_numbers")
public class ISBN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbnNumber ;

    public ISBN(Long id, String isbnNumber) {
        this.id = id;
        this.isbnNumber = isbnNumber;
    }

    public ISBN() {}

    public Long getId() {
        return id;
    }

    public String getisbnNumber() {
        return isbnNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setisbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
}
