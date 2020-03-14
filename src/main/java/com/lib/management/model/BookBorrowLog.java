package com.lib.management.model;

import java.math.BigDecimal;
import java.util.Date;

public class BookBorrowLog {
    private Integer logId;

    private Integer bookId;

    private Integer bookBorrowBy;

    private Date bookBorrowTime;

    private Date bookReturnTime;

    private Integer bookBorrowStatus;

    private Integer permitMoneyStatus;

    private BigDecimal permitMoneyNumber;

    private Integer fineStatus;

    private BigDecimal fineNumber;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookBorrowBy() {
        return bookBorrowBy;
    }

    public void setBookBorrowBy(Integer bookBorrowBy) {
        this.bookBorrowBy = bookBorrowBy;
    }

    public Date getBookBorrowTime() {
        return bookBorrowTime;
    }

    public void setBookBorrowTime(Date bookBorrowTime) {
        this.bookBorrowTime = bookBorrowTime;
    }

    public Date getBookReturnTime() {
        return bookReturnTime;
    }

    public void setBookReturnTime(Date bookReturnTime) {
        this.bookReturnTime = bookReturnTime;
    }

    public Integer getBookBorrowStatus() {
        return bookBorrowStatus;
    }

    public void setBookBorrowStatus(Integer bookBorrowStatus) {
        this.bookBorrowStatus = bookBorrowStatus;
    }

    public Integer getPermitMoneyStatus() {
        return permitMoneyStatus;
    }

    public void setPermitMoneyStatus(Integer permitMoneyStatus) {
        this.permitMoneyStatus = permitMoneyStatus;
    }

    public BigDecimal getPermitMoneyNumber() {
        return permitMoneyNumber;
    }

    public void setPermitMoneyNumber(BigDecimal permitMoneyNumber) {
        this.permitMoneyNumber = permitMoneyNumber;
    }

    public Integer getFineStatus() {
        return fineStatus;
    }

    public void setFineStatus(Integer fineStatus) {
        this.fineStatus = fineStatus;
    }

    public BigDecimal getFineNumber() {
        return fineNumber;
    }

    public void setFineNumber(BigDecimal fineNumber) {
        this.fineNumber = fineNumber;
    }
}