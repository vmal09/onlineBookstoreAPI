package com.mastercontroller.onlineBookstoreAPI.repository;

import com.mastercontroller.onlineBookstoreAPI.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);

}

