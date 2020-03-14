package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BookTypeMapper;
import com.lib.management.model.BookType;
import com.lib.management.service.BookTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    private BookTypeMapper bookTypeMapper;

    //private ReentrantLock lock = new ReentrantLock();

    @Override
    public boolean addANewType(BookType bookType) {
        boolean flag = false;
        try{
            bookTypeMapper.insert(bookType);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //暂不支持移除书籍分类
    @Override
    public boolean removeAOldType(int bookTypeId) {
        return false;
    }

    @Override
    public List<BookType> getAllType() {
        return bookTypeMapper.selectAllType();
    }

    @Override
    public int incrBookTypeCode(int bookTypeId) {
        //lock.lock();
        BookType bookType = bookTypeMapper.selectByPrimaryKey(1);
        bookType.setLargestCode(bookType.getLargestCode()+1);
        try {
            bookTypeMapper.updateByPrimaryKey(bookType);
            return bookType.getLargestCode();
        }catch (Exception e) {
            e.printStackTrace();
        }
        //lock.unlock();
        return -1;
    }

    @Override
    public boolean updateBookTypeByTypeId(BookType bookType) {
        boolean flag = false;
        try{
            bookTypeMapper.updateByPrimaryKey(bookType);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
