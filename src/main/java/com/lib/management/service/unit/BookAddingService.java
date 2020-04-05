package com.lib.management.service.unit;

import com.lib.management.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public interface BookAddingService {
    boolean addNewBook(int bookInfoId,int number);
}
