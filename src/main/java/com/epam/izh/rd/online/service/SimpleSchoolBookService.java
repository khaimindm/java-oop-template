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

    SimpleAuthorRepository sARsSBS = new SimpleAuthorRepository();
    SimpleSchoolBookRepository t = new SimpleSchoolBookRepository();
    SchoolBook t2 = new SchoolBook();

    public boolean save(SchoolBook book){ //Было: SchoolBook

        if (sARsSBS.findByFullName(book.getAuthorName(), book.getAuthorLastName()) == null) { //Попробовать вместо sARsSBS - authorService
            return false;
        }
        schoolBookBookRepository.save(book);
        return true;

    }

    public SchoolBook[] findByName(String name){
        return schoolBookBookRepository.findByName(name);
    }

    public int getNumberOfBooksByName(String name){

        int tGNOBBN = 0;
        for (int i = 0; i < t.getSchoolBooks().length; i++) {
            if (name == t.getSchoolBooks()[i].getName()) {
                tGNOBBN++;
            }
        }
        return tGNOBBN;

    }

    public boolean removeByName(String name){

        return schoolBookBookRepository.removeByName(name);

    }

    public int count(){
        return schoolBookBookRepository.count();
    }

    public Author findAuthorByBookName(String name){

        for (int i = 0; i < t.getSchoolBooks().length; i++) {
            if (name == t.getSchoolBooks()[i].getName()) {
                return authorService.findByFullName(t2.getAuthorName(), t2.getAuthorLastName());
            }
        }
        return null;

    }

}
