package com.frosales.favourite.books.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    private String autorName;

    private int year;

    private String isbm;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
    }
}
