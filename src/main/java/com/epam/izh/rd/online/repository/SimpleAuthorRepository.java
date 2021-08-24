package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    int s = 0;

    Author[] authors = new Author[s];

    boolean save(Author author){
        authors[s] = author;
        s++;
        authors = new Author[s];
    }

    Author findByFullName(String name, String lastname){
        if (name )

    }

    boolean remove(Author author){}

    int count(){}

    // Удалить? Author[] authors = new Author[0];

}
