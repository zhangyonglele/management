package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookTypeMapper;
import com.lib.management.model.BookType;
import com.lib.management.service.BookTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    private BookTypeMapper bookTypeMapper;

    @Override
    public boolean addANewType(BookType bookType) {
        return false;
    }

    @Override
    public boolean removeAOldType(int bookTypeId) {
        return false;
    }

    @Override
    public List<BookType> getAllType() {
        return null;
    }

    @Override
    public boolean incrBookTypeCode(int bookTypeId) {
        return false;
    }
}
