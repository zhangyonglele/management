package com.lib.management.service.unit;

import com.lib.management.model.Books;

public interface ReturnBookService {
    boolean returnBookRequest(int bookId);

    boolean resetBookPosition(int bookId, int room,int sheet,int level);
}
