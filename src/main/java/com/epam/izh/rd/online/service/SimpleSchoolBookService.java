package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService<SchoolBook>{
    public SimpleSchoolBookService(){}

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    public boolean save(SchoolBook book){
        boolean resultS;
        if (authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName()) == null) {
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
        test = schoolBookBookRepository.findByName(name);
        int c = 0;
        while (c < test.length) {
            test2 = authorService.findByFullName(test[c].getAuthorName(), test[c].getAuthorLastName());
            c++;
            break;
        }
        return test2;
    }
}
