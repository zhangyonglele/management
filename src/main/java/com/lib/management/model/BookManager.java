package com.lib.management.model;

import java.util.Date;

public class BookManager {
    private Integer bookManagerId;

    private String bookManagerName;

    private String bookManagerPassword;

    private Integer createBy;

    private Date createTime;

    private Integer activeStatus;

    public Integer getBookManagerId() {
        return bookManagerId;
    }

    public void setBookManagerId(Integer bookManagerId) {
        this.bookManagerId = bookManagerId;
    }

    public String getBookManagerName() {
        return bookManagerName;
    }

    public void setBookManagerName(String bookManagerName) {
        this.bookManagerName = bookManagerName == null ? null : bookManagerName.trim();
    }

    public String getBookManagerPassword() {
        return bookManagerPassword;
    }

    public void setBookManagerPassword(String bookManagerPassword) {
        this.bookManagerPassword = bookManagerPassword == null ? null : bookManagerPassword.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }
}