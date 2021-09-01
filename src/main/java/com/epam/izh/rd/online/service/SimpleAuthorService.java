package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.repository.AuthorRepository;

public class SimpleAuthorService implements AuthorService{

    private AuthorRepository authorRepository;

    public SimpleAuthorService () {

    }

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    boolean save(Author author){}

    Author findByFullName(String name, String lastname){}

    boolean remove(Author author){}

    int count(){}

}
