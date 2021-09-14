package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;

public class SimpleSchoolBookService implements BookService<SchoolBook>{

    public SimpleSchoolBookService(){}

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }


    SimpleSchoolBookRepository t = new SimpleSchoolBookRepository();
    SchoolBook t2 = new SchoolBook();

    public boolean save(SchoolBook book){ //Было: SchoolBook

        String t1;
        String t2;

        t1 = book.getAuthorName();
        t2 = book.getAuthorLastName();
        Author cc;
        cc = authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName());

        boolean resultS;

        if (authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName()) == null) { //Попробовать вместо sARsSBS - authorService
            resultS = false;
        } else {
            schoolBookBookRepository.save(book);
            resultS = true;
        }
        return resultS;

    }

    public SchoolBook[] findByName(String name){
        return schoolBookBookRepository.findByName(name);
    }

    public int getNumberOfBooksByName(String name){

        int l = 0;

        if (schoolBookBookRepository.findByName(name) != null) {
            l = schoolBookBookRepository.findByName(name).length;
        }

        /*int tGNOBBN = 0;
        for (int i = 0; i < t.getSchoolBooks().length; i++) {
            if (name == t.getSchoolBooks()[i].getName()) {
                tGNOBBN++;
            }
        }*/
        return l;

    }

    public boolean removeByName(String name){

        return schoolBookBookRepository.removeByName(name);

    }

    public int count(){
        return schoolBookBookRepository.count();
    }

    public Author findAuthorByBookName(String name){

        SchoolBook[] test;
        Author test2 = null;

        //test = t.getSchoolBooks();

        test = schoolBookBookRepository.findByName(name);

        int c = 0;
        while (c < test.length) {
            test2 = authorService.findByFullName(test[c].getAuthorName(), test[c].getAuthorLastName());
            c++;
            break;
        }

        /*for (int i = 0; i < t.getSchoolBooks().length; i++) {
            if (name == t.getSchoolBooks()[i].getName()) {
                return authorService.findByFullName(t2.getAuthorName(), t2.getAuthorLastName());
            }
        }*/

        return test2;
    }

}
