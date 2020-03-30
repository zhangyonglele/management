package com.lib.management.service;

import com.lib.management.model.Books;

public interface BookService {
    boolean addNewBookCopy(Books books,int number);

    boolean updateBookInfo(Books books);

    Books getBookByBookId(Integer bookId);

    Integer updateBook(Books book);

    boolean bookBorrow(int readerId,int bookId);
}
