package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;

public class SimpleSchoolBookService implements BookService{

    public SimpleSchoolBookService(){}

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    SimpleAuthorRepository sARsSBS = new SimpleAuthorRepository();
    SimpleSchoolBookRepository t = new SimpleSchoolBookRepository();

    public boolean save(SchoolBook book){

        if (sARsSBS.findByFullName(book.getAuthorName(), book.getAuthorLastName()) == null) { //Попробовать вместо sARsSBS - authorService
            return false;
        }
        schoolBookBookRepository.save(book);
        return true;

    }

    public SchoolBook[] findByName(String name){
        return schoolBookBookRepository.findByName(name);
    }

    int getNumberOfBooksByName(String name){

        schoolBookBookRepository.findByName(name);
    }

    boolean removeByName(String name){}

    int count(){}

    Author findAuthorByBookName(String name){}

}
