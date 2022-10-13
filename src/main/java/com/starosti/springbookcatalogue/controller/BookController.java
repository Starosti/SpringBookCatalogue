package com.starosti.springbookcatalogue.controller;

import com.starosti.springbookcatalogue.dto.BookDto;
import com.starosti.springbookcatalogue.entity.Book;
import com.starosti.springbookcatalogue.service.BookService;
import com.starosti.springbookcatalogue.service.DtoMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    private final DtoMappingService dtoMappingService;

    @Autowired
    public BookController(BookService bookService, DtoMappingService dtoMappingService){
        this.bookService = bookService;
        this.dtoMappingService = dtoMappingService;
    }

    @GetMapping("/")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookService.findBookById(id);
    }

    @PostMapping("/")
    public Book addBook(@RequestBody BookDto book){
        return bookService.addBook(dtoMappingService.convertDtoToBook(book));
    }

    @PutMapping("/")
    public Book updateBook(@RequestBody BookDto book){
        return bookService.updateBook(dtoMappingService.convertDtoToBook(book));
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        if(bookService.removeBookById(id)){
            return "Successfully removed!";
        }
        else{
            return "Couldn't find the book!";
        }
    }
}
