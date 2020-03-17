package com.lib.management.dto;

import com.lib.management.model.BookInfo;
import lombok.Data;

@Data
public class BookInfoHelper {

    private Integer bookType;

    private String bookName;

    private String bookPrice;

    private String bookAuthor;

    private String bookPublisher;

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
