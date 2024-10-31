package com.frosales.favourite.books.services;

import com.frosales.favourite.books.entity.Book;
import com.frosales.favourite.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> listsBooks() {
        return (List<Book>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> listByBookId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
