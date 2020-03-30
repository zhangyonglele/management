package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BooksMapper;
import com.lib.management.model.Books;
import com.lib.management.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BooksMapper booksMapper;

    @Override
    public boolean addNewBookCopy(Books books, int number) {
        Date currentDate = new Date();
        books.setLocationUpdateTime(currentDate);
        books.setBookBorrowStatus(0);
        books.setBookBorrowStatus(0);
        books.setBookBorrowUpdateTime(currentDate);
        books.setBookActiveStatus(1);
        boolean flag = false;
        // TODO: 2020/3/25 这里有问题 
        while(number > 0){
            try{
                booksMapper.insert(books);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
            number--;
        }
        return flag;
    }

    @Override
    public boolean updateBookInfo(Books books) {
        return false;
    }
    //查找图书
    @Override
    public Books getBookByBookId(Integer bookId) {
        return booksMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public Integer updateBook(Books book) {
        int i = booksMapper.updateByPrimaryKey(book);
        return i;
    }

    @Override
    public boolean bookBorrow(int readerId, int bookId) {
        Books book = booksMapper.selectByPrimaryKey(bookId);
        if(book == null){
            return false;
        }
        //检查并刷新书籍可能存在的预约状态
        book.checkAndRefreshPreOrderActive();
        if(book.getBookBorrowStatus() > 0){
            return false;
        }
        book.setBookBorrowStatus(1);
        book.setBookBorrowBy(readerId);
        book.initBookBorrowTime();
        booksMapper.updateByPrimaryKeySelective(book);
        return true;
    }


}
