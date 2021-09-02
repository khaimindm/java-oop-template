package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    int s = 0;
    int t;

    Author[] authors = new Author[s];

    SimpleAuthorRepository fBFN = new SimpleAuthorRepository();

    public boolean save(Author author){

        if (fBFN.findByFullName(author.getName(), author.getLastName()) == null) {
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
        fBFN.findByFullName(author.getName(), author.getLastName())
        if (fBFN.findByFullName(author.getName(), author.getLastName()) != null) {
            Author[] authors = new Author[s--];
            for (int i=0; i < authors.length; i++) {
                if (authors[i] != null) {

                }
            }
            //System.arraycopy(authors, 0, authors, 0, authors.length);
        }

    }

    public int count(){}


}
