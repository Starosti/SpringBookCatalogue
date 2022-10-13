package com.starosti.springbookcatalogue.controller;

import com.starosti.springbookcatalogue.dto.AuthorDto;
import com.starosti.springbookcatalogue.entity.Author;
import com.starosti.springbookcatalogue.service.AuthorService;
import com.starosti.springbookcatalogue.service.DtoMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    private final DtoMappingService dtoMappingService;

    @Autowired
    public AuthorController(AuthorService authorService,DtoMappingService dtoMappingService){
        this.authorService = authorService;
        this.dtoMappingService = dtoMappingService;
    }

    @GetMapping("/")
    public List<Author> getAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable("id") Long id){
        return authorService.findAuthorById(id);
    }

    @PostMapping("/")
    public Author addAuthor(@RequestBody AuthorDto author){
        return authorService.addAuthor(dtoMappingService.convertDtoToAuthor(author));
    }

    @PutMapping("/")
    public Author updateAuthor(@RequestBody AuthorDto author){
        return authorService.updateAuthor(dtoMappingService.convertDtoToAuthor(author));
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable("id") Long id){
        if(authorService.removeAuthorById(id)){
            return "Successfully removed!";
        }
        else{
            return "Couldn't find the author!";
        }
    }
}
