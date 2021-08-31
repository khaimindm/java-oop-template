package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    int s = 0;

    Author[] authors = new Author[s];

    boolean save(Author author){
        if (
                new  SimpleAuthorRepository().findByFullName(String name, String lastname);
                //SimpleAuthorRepository.findByFullName();
                //public Author findByFullName(String name, String lastname){};
        authorService.findByFullName
                )
        authors[s] = author;
        s++;
        authors = new Author[s];
    }

    public Author findByFullName(String name, String lastname){

        for (int i=0; i< authors.length; i++) {
            if (name == authors[i].getName() && lastname == authors[i].getLastName()) {
                return authors[i];
            }
        }
        return null;
    }

    boolean remove(Author author){}

    int count(){}

    // Удалить? Author[] authors = new Author[0];

}
