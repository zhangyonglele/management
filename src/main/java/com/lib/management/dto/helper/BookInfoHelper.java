package com.lib.management.dto.helper;

import com.lib.management.model.BookInfo;
import lombok.Data;

/**
 * This class use for Help Controller input
 */
public class BookInfoHelper {

    private Integer bookType;

    private String bookName;

    private String bookPrice;

    private String bookAuthor;

    private String bookPublisher;

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public BookInfo toBookInfo(){
        BookInfo res = new BookInfo();
        res.setBookType(bookType);
        res.setBookAuthor(bookAuthor);
        res.setBookPublisher(bookPublisher);
        res.setBookPrice(bookPrice);
        res.setBookName(bookName);
        return res;
    }
}
