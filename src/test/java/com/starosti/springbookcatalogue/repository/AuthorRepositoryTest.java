package com.starosti.springbookcatalogue.repository;

import com.starosti.springbookcatalogue.entity.Author;
import com.starosti.springbookcatalogue.entity.Book;
import com.starosti.springbookcatalogue.entity.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class AuthorRepositoryTest {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorRepositoryTest(AuthorRepository authorRepository, GenreRepository genreRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    @Test
    void testFunc(){
        Genre genre = Genre.builder()
                .name("Horror")
                .build();
        Author author = Author.builder()
                .name("Philips H. Pendleton")
                .dateOfBirth(LocalDate.of(
                        2000,
                        4,
                        25
                ))
                .build();
        Book book = Book.builder()
                .name("Programming with PHP")
                .length(1000)
                .genre(genre)
                .author(author)
                .build();
        author.addBook(book);

        genreRepository.save(genre);
        authorRepository.save(author);

    }
}