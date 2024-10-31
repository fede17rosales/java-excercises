package com.frosales.favourite.books.controller;


import com.frosales.favourite.books.entity.Book;
import com.frosales.favourite.books.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> listsBooks() {
        return ResponseEntity.ok(service.listsBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listBookById(@PathVariable Long id){
        Optional<Book> optional = service.listByBookId(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> saveBook(@Valid @RequestBody Book book, BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }
        Book bookDb = service.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDb);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editBook(@Valid @RequestBody Book book, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validar(result);
        }
        Optional<Book> optionalBook = service.listByBookId(id);
        if(optionalBook.isPresent()){
            Book bookDb = optionalBook.get();
            bookDb.setName(book.getName());
            bookDb.setAutorName(book.getAutorName());
            bookDb.setYear(book.getYear());
            bookDb.setIsbm(book.getIsbm());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBook(bookDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Book> optionalBook = service.listByBookId(id);
        if(optionalBook.isPresent()){
            service.deleteBook(optionalBook.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
