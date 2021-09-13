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

    //SimpleAuthorRepository sAR = new SimpleAuthorRepository();

    public boolean save(Author author){

        return authorRepository.save(author);

    }

    public Author findByFullName(String name, String lastname){

        return authorRepository.findByFullName(name, lastname);

    }

    public boolean remove(Author author){

        return authorRepository.remove(author);

    }

    public int count(){

        return authorRepository.count();

    }

/*Возможные ошибки.
if (sAR.save(author)) возможно в качестве аргумента должен быть не author
return authorRepository.save(author);
*/
}
