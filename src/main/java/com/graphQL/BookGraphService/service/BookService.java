package com.graphQL.BookGraphService.service;

import com.graphQL.BookGraphService.dto.BookInput;
import com.graphQL.BookGraphService.entity.Book;
import com.graphQL.BookGraphService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Book not found with id"+id));
    }

    public Book createBook(BookInput bookInput){
        Book book = Book.builder()
                .name(bookInput.getName())
                .author(bookInput.getAuthor())
                .pages(bookInput.getPages())
                .build();
        return bookRepository.save(book);
    }
}
