package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.BooksMapper;
import com.lib.management.model.Books;
import com.lib.management.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Resource
    private BooksMapper booksMapper;

    @Override
    public boolean addNewBookCopy(Books books, int number) {
        Date currentDate = new Date();
        books.setLocationUpdateTime(currentDate);
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
    public boolean removeBookCopy(Integer bookCopyId) {
        Books book = null;
        boolean flag = false;
        book = booksMapper.selectByPrimaryKey(bookCopyId);
        if(book != null && book.getBookActiveStatus() == 1){
            book.setBookActiveStatus(0);
            try {
                booksMapper.updateByPrimaryKey(book);
                flag = true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return flag;
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


    @Override
    public boolean makeBookWaitingForResetPosition(int bookId) {
        Books book = booksMapper.selectByPrimaryKey(bookId);
        if(book == null){
            return false;
        }
        //设置书本为待复位阶段
        book.setBookBorrowStatus(3);
        boolean flag = false;
        try{
            booksMapper.updateByPrimaryKey(book);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean setBookReturn(int bookId,int room,int sheet,int layer) {
        Books book = booksMapper.selectByPrimaryKey(bookId);
        book.setBookLocationRoom(room);
        book.setBookLocationSheet(sheet);
        book.setBookLocationSheetLevel(layer);
        book.setBookBorrowStatus(0);
        book.setLocationUpdateTime(new Date());
        boolean flag = false;
        try{
            booksMapper.updateByPrimaryKey(book);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
