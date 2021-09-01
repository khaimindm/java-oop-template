package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;

public class SimpleAuthorService implements AuthorService{

    private AuthorRepository authorRepository;

    public SimpleAuthorService () {

    }

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //Author t;
    //SimpleAuthorService sAS = new SimpleAuthorService();
    SimpleAuthorRepository sAR = new SimpleAuthorRepository();

    public boolean save(Author author){
        //authorRepository.save(author);
        //return false;
        if (sAR.save(author)) {
            return true;
        }
        return false;
    }

    Author findByFullName(String name, String lastname){}

    boolean remove(Author author){}

    int count(){}

}
