package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;


public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {

    int sASB = 1;
    int pB = 0;

    private SchoolBook[] schoolBooks = new SchoolBook[sASB];
    private SchoolBook[] schoolBooks1 = new SchoolBook[sASB];

    public boolean save(SchoolBook book){

        boolean resultss = false;

        if (sASB != 1) {
            schoolBooks1 = new SchoolBook[schoolBooks.length];
            System.arraycopy(schoolBooks, 0, schoolBooks1, 0, schoolBooks.length);
            sASB++;
            schoolBooks = new SchoolBook[sASB];
            System.arraycopy(schoolBooks1, 0, schoolBooks, 0, schoolBooks1.length);
            schoolBooks[sASB - 1] = new SchoolBook();
            schoolBooks[sASB - 1] = book;
            resultss = true;
        } else {
            schoolBooks[0] = new SchoolBook();
            schoolBooks[0] = book;
            sASB++;
            resultss = true;
        }

        return resultss;

    }

    public SchoolBook[] findByName(String name) {

        int sASBf = 1;
        int pSB2f = 0;

        SchoolBook[] schoolBooks = new  SchoolBook[sASBf];
        SchoolBook[] schoolBooks2 = new SchoolBook[sASBf];




        for (int i=0; i< this.schoolBooks.length; i++) {
            if (name == this.schoolBooks[i].getName()) {
                sASBf++;
            }
        }

        schoolBooks2 = new SchoolBook[sASBf];

        for (int i = 0; i < this.schoolBooks.length; i++) {
            if (name == this.schoolBooks[i].getName()) {
                schoolBooks2[pSB2f] = this.schoolBooks[i];
                pSB2f++;
            }
        }

        schoolBooks = new SchoolBook[sASBf];

        schoolBooks = schoolBooks2;

        return schoolBooks;


        /*schoolBooks2[pSB2f] = this.schoolBooks[i];
        System.arraycopy();

        schoolBooks = new SchoolBook[sASBf++];
        schoolBooks[i] = this.schoolBooks[i];
        return schoolBooks;
        return schoolBooks;*/
        
    }

    public boolean removeByName(String name) {

        SchoolBook[] schoolBooks = new SchoolBook[sASB];
        for (int i = 0; i < schoolBooks.length; i++) {
            if (name == this.schoolBooks[i].getName()) {
                this.schoolBooks[i] = null;
                schoolBooks = new SchoolBook[--sASB];
                for (int j = 0; j < schoolBooks.length; j++) {
                    if (this.schoolBooks[i] != null) {
                        schoolBooks[j] = this.schoolBooks[i];
                    }
                }
            }
            this.schoolBooks = schoolBooks;
            return true;
        }
        return false;
    }

    public int count() {

        return schoolBooks.length;
        
    }

    public void setSchoolBooks(SchoolBook[] schoolBooks) {
        this.schoolBooks = schoolBooks;
    }

    public SchoolBook[] getSchoolBooks() {
        return schoolBooks;
    }
}
