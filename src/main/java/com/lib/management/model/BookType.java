package com.lib.management.model;

import java.util.Date;

public class BookType {
    private Integer bookTypeId;

    private String bookTypeMark;

    private String bookTypeName;

    private Date createTime;

    private Integer createBy;

    private Integer largestCode;

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeMark() {
        return bookTypeMark;
    }

    public void setBookTypeMark(String bookTypeMark) {
        this.bookTypeMark = bookTypeMark == null ? null : bookTypeMark.trim();
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName == null ? null : bookTypeName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getLargestCode() {
        return largestCode;
    }

    public void setLargestCode(Integer largestCode) {
        this.largestCode = largestCode;
    }
}