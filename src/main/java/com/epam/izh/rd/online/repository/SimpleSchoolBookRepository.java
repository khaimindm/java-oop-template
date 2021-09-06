package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;


public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    int sASB = 0;

    private SchoolBook[] schoolBooks = new SchoolBook[sASB];

    public boolean save(SchoolBook book){

        schoolBooks[sASB] = book;
        sASB++;
        schoolBooks = new SchoolBook[sASB];
        return true;

    }

    public SchoolBook[] findByName(String name) {

        int sASBf = 0;
        SchoolBook[] schoolBooks = new SchoolBook[sASBf];
        for (int i=0; i< this.schoolBooks.length; i++) {
            if (name == this.schoolBooks[i].getName()) {
                schoolBooks = new SchoolBook[sASBf++];
                schoolBooks[i] = this.schoolBooks[i];
                return schoolBooks;
            }
        }
        return schoolBooks;
        
    }
}
