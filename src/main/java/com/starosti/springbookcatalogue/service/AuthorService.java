package com.starosti.springbookcatalogue.service;

import com.starosti.springbookcatalogue.entity.Author;
import com.starosti.springbookcatalogue.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author findAuthorById(Long id){
        return authorRepository.findById(id).orElseThrow();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author updateAuthor(Author author){
        Author updatedAuthor = authorRepository.findById(author.getId()).orElseThrow();
        if (author.getName() != null){
            updatedAuthor.setName(author.getName());
        }
        if (author.getDateOfBirth() != null){
            updatedAuthor.setDateOfBirth(author.getDateOfBirth());
        }
        return authorRepository.save(updatedAuthor);
    }

    public boolean removeAuthorById(Long id){
        boolean exists = authorRepository.existsById(id);
        authorRepository.deleteById(id);
        return exists;
    }

}
