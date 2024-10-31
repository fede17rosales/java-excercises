package com.frosales.favourite.books.repository;

import com.frosales.favourite.books.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
