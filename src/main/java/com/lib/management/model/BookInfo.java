package com.lib.management.model;

public class BookInfo {
    private Integer bookInfoId;

    private String bookType;

    private Integer bookTypeCode;

    private String bookName;

    private String bookPrice;

    private String bookAuthor;

    private String bookPublisher;

    private Integer createBy;

    private Integer bookCopyNumber;

    private Integer bookStatus;

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType == null ? null : bookType.trim();
    }

    public Integer getBookTypeCode() {
        return bookTypeCode;
    }

    public void setBookTypeCode(Integer bookTypeCode) {
        this.bookTypeCode = bookTypeCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice == null ? null : bookPrice.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher == null ? null : bookPublisher.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getBookCopyNumber() {
        return bookCopyNumber;
    }

    public void setBookCopyNumber(Integer bookCopyNumber) {
        this.bookCopyNumber = bookCopyNumber;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }
}