package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{
    int sAA = 1;
    int p = 0;
    int t = 0;
    private Author[] authors = new Author[sAA];
    private Author[] authors1 = new Author[sAA];

    public boolean save(Author author){
        boolean resultS;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = new Author();
            }
        }
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            authors1 = new Author[authors.length];
            System.arraycopy(authors, 0, authors1, 0, authors.length);
            authors = new Author[sAA];
            System.arraycopy(authors1, 0, authors, 0, authors1.length);
            authors[p] = author;
            p++;
            if (sAA > 1) {
                authors[sAA -1] = new Author();
            }
            sAA++;
            resultS = true;
        } else {
            resultS = false;
        }
        return resultS;
    }

    public Author findByFullName(String name, String lastname){
        Author resultF = null;
        int c = 0;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = new Author();
            }
        }
        while (c < authors.length) {
            if (name == authors[c].getName() && lastname == authors[c].getLastName()) {
                t = c;
                resultF = authors[c];
                break;
            }
            c++;
        }
        return resultF;
    }

    public boolean remove(Author author){
        int sA = 0;
        int sAN = authors.length;
        boolean resultRA;
        resultRA = false;
        for (int i = 0; i < authors.length; i++) {
            if (findByFullName(author.getName(), author.getLastName()) != null) {
                authors[i] = null;
                sA++;
                resultRA = true;
            }
        }
        Author[] authors2 = new Author[sAN - sA];
        for (int j = 0; j < authors2.length; j++) {
            if (authors[j] != null) {
                authors2[j] = authors[j];
            }
        }
        authors = new Author[authors2.length];
        System.arraycopy(authors2, 0, authors, 0, authors2.length);
        return resultRA;
    }

    public int count(){
        return authors.length;
    }
}
