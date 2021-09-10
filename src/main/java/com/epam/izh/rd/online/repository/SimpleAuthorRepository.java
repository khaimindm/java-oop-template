package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    int s = 1;
    int p = 0;
    int t = 0;

    Author author = new Author();

    private Author[] authors = new Author[s];

    //SimpleAuthorRepository fBFN = new SimpleAuthorRepository();



    public boolean save(Author author){

        String h;
        Author h2;
        Author g;

        boolean resultS = false;
        h = author.getName();
        g = findByFullName(author.getName(), author.getLastName());

        if (findByFullName(author.getName(), author.getLastName()) == null) {  //fBFN.
            authors[p] = author;
            s++;
            p++;
            authors = new Author[s];
            resultS = true;
            h = authors[p].getName();
            h2 = authors[p];

        } else {
            resultS = false;
        }

        return resultS;

    }

    public Author findByFullName(String name, String lastname){

        Author resultF = null;
        String test;
        test = author.getName();

        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null || authors[i].getName() == null) {
                return null;
            }
        }

        for (int j=0; j< authors.length; j++) {
            if (name == authors[j].getName() && lastname == authors[j].getLastName()) {
                t = j;
                resultF = authors[j];
            } else {
                resultF = null;
            }
        }
        return resultF;
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
