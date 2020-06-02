package com.lib.management.factory;

import com.lib.management.model.BookControlLog;

import java.util.Date;

public class BookControlLogFactory {
    public static BookControlLog getAddingCopyLog(){
        BookControlLog newLog = new BookControlLog();
        newLog.setLogType(5);
        newLog.setOptionContain("[add] book copy");
        newLog.setUpdateTime(new Date());
        return newLog;
    }

    public static BookControlLog getDeleteCopyLog(){
        BookControlLog newLog = new BookControlLog();
        newLog.setLogType(5);
        newLog.setOptionContain("[delete] book copy");
        newLog.setUpdateTime(new Date());
        return newLog;
    }

    public static BookControlLog getAddingNewBookInfoLog(String bookName) {
        BookControlLog newLog = new BookControlLog();
        newLog.setLogType(5);
        newLog.setOptionContain("add [new book information]: " + bookName + " ");
        newLog.setUpdateTime(new Date());
        return newLog;
    }
    public static BookControlLog getDeleteBookInfoLog(){
            BookControlLog newLog = new BookControlLog();
            newLog.setLogType(5);
            newLog.setOptionContain("delete [book information]");
            newLog.setUpdateTime(new Date());
            return newLog;
    }
    public static BookControlLog getAddingBookTypeLog(String bookType){
        BookControlLog newLog = new BookControlLog();
        newLog.setLogType(5);
        newLog.setOptionContain("add new book [type] information: "+bookType+" ");
        newLog.setUpdateTime(new Date());
        return newLog;
    }

    public static BookControlLog getDeleteBookTypeLog(){
        BookControlLog newLog = new BookControlLog();
        newLog.setLogType(5);
        newLog.setOptionContain("[delete] book [type] information: ");
        newLog.setUpdateTime(new Date());
        return newLog;
    }
}
