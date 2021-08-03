package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;

public class SimpleSchoolBookService implements BookService{
    public SimpleSchoolBookService(){}

    SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService){}

    boolean save(T book){}

    T[] findByName(String name){}

    int getNumberOfBooksByName(String name){}

    boolean removeByName(String name){}

    int count(){}

    Author findAuthorByBookName(String name){}

    private BookRepository<SchoolBook> schoolBookBookRepository;

    private AuthorService authorService;
}
