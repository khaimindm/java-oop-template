package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{

    int sAA = 1;
    int p = 0;
    int t = 0;

    //Author author = new Author();

    private Author[] authors = new Author[sAA];
    private Author[] authors1 = new Author[sAA];

    //SimpleAuthorRepository fBFN = new SimpleAuthorRepository();


    public boolean save(Author author){

        String h;
        String h2;
        //Author g;

        boolean resultS = false;
        if (authors[p] == null) {
            authors[p] = new Author();
        }

        /*h = author.getName();
        g = findByFullName(author.getName(), author.getLastName());*/

        if (findByFullName(author.getName(), author.getLastName()) == null) {  //fBFN.
            //authors[p] = new Author();
            authors[p] = author;

            /*g = authors[p];
            h = g.getName();
            h2 = h;*/

            sAA++;
            p++;
            authors1 = new Author[authors.length];
            System.arraycopy(authors, 0, authors1, 0, authors.length);
            authors = new Author[sAA];
            System.arraycopy(authors1, 0, authors, 0, authors1.length);
            //authors[sAA -1] = new Author();
            System.out.println(authors[p-1].getName() + authors[p-1].getLastName());
            h = authors[p-1].getName();
            h2 = authors[p-1].getLastName();
            authors[p-1].getName();
            authors[p-1].getLastName();
            resultS = true;

        } else {
            resultS = false;
        }

        return resultS;

    }

    public Author findByFullName(String name, String lastname){

        Author resultF = null;
        int c = 0;

        /*String test;
        String test2;
        test = author.getName();*/

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

        if (findByFullName(author.getName(), author.getLastName()) != null) { //fBFN.
            this.authors[t] = null;
            Author[] authors = new Author[sAA--];
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
