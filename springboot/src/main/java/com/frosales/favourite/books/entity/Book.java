package com.frosales.favourite.books.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    private Long id;

    private String name;

    private String autorName;

    private int year;

    private String isbm;

}
