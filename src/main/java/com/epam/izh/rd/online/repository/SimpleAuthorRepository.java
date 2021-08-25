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

        for (int i=0; i< authors.length; i++) {
            if (name == authors[i].name && lastname == authors[i].lastName) {
                return authors[i];
            }
        }
        return null;
    }

    boolean remove(Author author){}

    int count(){}

    // Удалить? Author[] authors = new Author[0];

}
