package com.lib.management.dto.helper;

import com.lib.management.model.Books;
import lombok.Data;

@Data
public class BookCopyHelper {
    private Integer bookInfoId;

    private Integer bookLocationRoom;

    private Integer bookLocationSheet;

    private Integer bookLocationSheetLevel;

    public Books toBook(){
        Books book = new Books();
        book.setBookInfoId(bookInfoId);
        book.setBookLocationRoom(bookLocationRoom);
        book.setBookLocationSheet(bookLocationSheet);
        book.setBookLocationSheetLevel(bookLocationSheetLevel);
        return book;
    }
}
