package com.lib.management.dto;

import com.lib.management.model.BookManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.util.Date;

@Data
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


    public BookManagerHelper(String name, String password){
        bookManagerName = name;
        bookManagerPassword = password;
    }

    public BookManager toBookManager(){
        BookManager res = new BookManager();
        res.setBookManagerName(bookManagerName);
        res.setBookManagerPassword(bookManagerPassword);
        return res;
    }
}
