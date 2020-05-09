package com.lib.management.service;

import com.lib.management.model.Books;

public interface BookService {
    boolean addNewBookCopy(Books books,int number);

    boolean updateBookInfo(Books books);

    Books getBookByBookId(Integer bookId);

    Integer updateBook(Books book);

    boolean bookBorrow(int readerId,int bookId);

    /**
     * 将书本设置为待复位状态
     * @param bookId 书本id
     * @return 返回是否设置成功
     */
    boolean makeBookWaitingForResetPosition(int bookId);

    boolean setBookReturn(int bookId,int room,int sheet,int layer);
}
