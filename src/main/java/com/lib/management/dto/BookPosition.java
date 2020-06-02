package com.lib.management.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * book_position a view in database
 * @author 
 */
public class BookPosition implements Serializable {
    /**
     * 每本书的id
     */
    private Integer bookId;

    /**
     * 书基本信息id
     */
    private Integer bookInfoId;

    /**
     * 图书室坐标
     */
    private Integer bookLocationRoom;

    /**
     * 图书室内书架坐标
     */
    private Integer bookLocationSheet;

    /**
     * 书架上层坐标
     */
    private Integer bookLocationSheetLevel;

    /**
     * 坐标更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date locationUpdateTime;

    /**
     * 该书的借阅状态 0，在馆；1，被借阅；3，正在归位；4，被预约
     */
    private Integer bookBorrowStatus;

    /**
     * 这本书的可使用状态,0为不可用,1为可用
     */
    private Integer bookActiveStatus;

    private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Integer getBookLocationRoom() {
        return bookLocationRoom;
    }

    public void setBookLocationRoom(Integer bookLocationRoom) {
        this.bookLocationRoom = bookLocationRoom;
    }

    public Integer getBookLocationSheet() {
        return bookLocationSheet;
    }

    public void setBookLocationSheet(Integer bookLocationSheet) {
        this.bookLocationSheet = bookLocationSheet;
    }

    public Integer getBookLocationSheetLevel() {
        return bookLocationSheetLevel;
    }

    public void setBookLocationSheetLevel(Integer bookLocationSheetLevel) {
        this.bookLocationSheetLevel = bookLocationSheetLevel;
    }

    public Date getLocationUpdateTime() {
        return locationUpdateTime;
    }

    public void setLocationUpdateTime(Date locationUpdateTime) {
        this.locationUpdateTime = locationUpdateTime;
    }

    public Integer getBookBorrowStatus() {
        return bookBorrowStatus;
    }

    public void setBookBorrowStatus(Integer bookBorrowStatus) {
        this.bookBorrowStatus = bookBorrowStatus;
    }

    public Integer getBookActiveStatus() {
        return bookActiveStatus;
    }

    public void setBookActiveStatus(Integer bookActiveStatus) {
        this.bookActiveStatus = bookActiveStatus;
    }
}