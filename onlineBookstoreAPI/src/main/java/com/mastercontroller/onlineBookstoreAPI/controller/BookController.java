package com.mastercontroller.onlineBookstoreAPI.controller;

import com.mastercontroller.onlineBookstoreAPI.model.Book;
import com.mastercontroller.onlineBookstoreAPI.repository.BookRepository;
import com.mastercontroller.onlineBookstoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    private BookRepository bookRepository;


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title) {
        try {
            List<Book> books = new ArrayList<Book>();

            if (title == null)
                bookRepository.findAll().forEach(books::add);
            else
                bookRepository.findByTitleContaining(title).forEach(books::add);

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setIsbn(updatedBook.getIsbn());
                    book.setPrice(updatedBook.getPrice());
                    book.setPublicationYear(updatedBook.getPublicationYear());
                    Book savedBook = bookRepository.save(book);
                    return ResponseEntity.ok(savedBook);
                })
                .orElseGet(() -> {
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
