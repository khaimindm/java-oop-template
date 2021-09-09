package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    int s = 0;
    int t = 5;

//    AuthorRepository a;

    private Author[] authors = new Author[s];

//    SimpleAuthorRepository fBFN = new SimpleAuthorRepository();

    public boolean save(Author author){

        if (findByFullName(author.getName(), author.getLastName()) == null) {  //fBFN.
            authors[s] = author;
            s++;
            authors = new Author[s];
            return true;
        }
        return false;

    }

    public Author findByFullName(String name, String lastname){

        for (int i=0; i< authors.length; i++) {
            if (name == authors[i].getName() && lastname == authors[i].getLastName()) {
                t = i;
                return authors[i];
            }
        }
        return null;
    }

    public boolean remove(Author author){

        if (findByFullName(author.getName(), author.getLastName()) != null) { //fBFN.
            this.authors[t] = null;
            Author[] authors = new Author[s--];
            for (int i=0; i < authors.length; i++) {
                if (this.authors[i] != null) {
                    authors[i] = this.authors[i];
                }
            }
            this.authors = authors;
            return true;
        }
        return false;

    }

    public int count(){

        return authors.length;

    }

/*Возможные ошибки.
Модификатор доступа для методов public*/
}
