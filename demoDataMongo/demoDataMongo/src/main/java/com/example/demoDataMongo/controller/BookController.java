package com.example.demoDataMongo.controller;

import com.example.demoDataMongo.model.Book;
import com.example.demoDataMongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book", produces = {"application/json"})
public class BookController {

    private BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return repository.save(book);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Book getBookById(@PathVariable String id){

        return repository.findById(id).get();
    }
}


