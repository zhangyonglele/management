package com.lib.management.service;

import com.lib.management.model.BookType;

import java.util.List;

public interface BookTypeService {
    boolean addANewType(BookType bookType);

    boolean removeAOldType(int bookTypeId);

    BookType getABookType(int bookTypeId);

    List<BookType> getAllType();

    boolean updateBookTypeByTypeId(BookType bookType);

    int incrBookTypeCode(int bookTypeId);
}
