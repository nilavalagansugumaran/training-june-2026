package com.example.demoDataMongo.controller;

import com.example.demoDataMongo.model.Book;
import com.example.demoDataMongo.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/book", produces = {"application/json"})
public class BookController {

    private BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book createBook(@Valid @RequestBody Book book){
        return repository.save(book);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Book getBookById(@PathVariable String id){

        return repository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        errors.put("errorCode", String.valueOf(exception.getBody().getStatus()));

        exception.getBindingResult().getAllErrors().forEach((e) -> {

            String fieldName = ((FieldError)e).getField();
            String errormessage = e.getDefaultMessage();
            errors.put(fieldName, errormessage);
        });
        return errors;

    }
}


