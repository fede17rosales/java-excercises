package com.frosales.favourite.books.services;

import com.frosales.favourite.books.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listsBooks();

    Optional<Book> listByBookId(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);

}
