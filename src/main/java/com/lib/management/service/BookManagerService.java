package com.lib.management.service;

import com.lib.management.model.BookManager;

public interface BookManagerService {
    BookManager getBookManagerInfoByName(String name);
    
    boolean changeManagerAccountStatus(String userName,int futureStatus);
}
