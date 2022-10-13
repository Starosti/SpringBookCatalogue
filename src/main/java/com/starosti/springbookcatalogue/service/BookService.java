package com.starosti.springbookcatalogue.service;

import com.starosti.springbookcatalogue.entity.Book;
import com.starosti.springbookcatalogue.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public Book updateBook(Book book){
        Book updatedBook = bookRepository.findById(book.getId()).orElseThrow();
        if (book.getName() != null){
            updatedBook.setName(book.getName());
        }
        if (book.getLength() != 0){
            updatedBook.setLength(book.getLength());
        }
        if (book.getGenre() != null){
            updatedBook.setGenre(book.getGenre());
        }
        if (book.getAuthor() != null){
            updatedBook.setAuthor(book.getAuthor());
        }
        return bookRepository.save(updatedBook);
    }

    public boolean removeBookById(Long id){
        boolean exists = bookRepository.existsById(id);
        if (exists) bookRepository.deleteById(id);
        return exists;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
