package com.lib.management.service;

import com.lib.management.dto.helper.BookManagerHelper;
import com.lib.management.model.BookManager;

public interface BookManagerService {
    BookManager getBookManagerInfoByName(String name);
    
    boolean changeManagerAccountStatus(String userName,int futureStatus);

    boolean registerForNewManager(BookManagerHelper bookManagerHelper);

    boolean changeManagerAccountName(String name,String password, String newName);

    boolean initialManagerAccount(String name);

    boolean deleteAccount(String name);
}
