package com.graphQL.BookGraphService.controller;


import com.graphQL.BookGraphService.dto.BookInput;
import com.graphQL.BookGraphService.entity.Book;
import com.graphQL.BookGraphService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument Long id){
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Book saveBook(@Argument("input") BookInput bookInput){
        return bookService.createBook(bookInput);
    }


}
