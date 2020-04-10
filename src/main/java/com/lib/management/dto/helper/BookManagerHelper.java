package com.lib.management.dto.helper;

import com.lib.management.model.BookManager;

import java.util.Date;

public class BookManagerHelper {
    private String bookManagerName;

    private String bookManagerPassword;


    public String getBookManagerName() {
        return bookManagerName;
    }

    public void setBookManagerName(String bookManagerName) {
        this.bookManagerName = bookManagerName;
    }

    public String getBookManagerPassword() {
        return bookManagerPassword;
    }

    public void setBookManagerPassword(String bookManagerPassword) {
        this.bookManagerPassword = bookManagerPassword;
    }


    public BookManager toBookManager(){
        BookManager res = new BookManager();
        res.setBookManagerName(bookManagerName);
        res.setBookManagerPassword(bookManagerPassword);
        return res;
    }
}
