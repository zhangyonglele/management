package com.lib.management.dto;

import lombok.Data;

/**
 * this class is obsolete, please use BookWithPic to dev new Function
 */
@Data
public class BookInfoResponse {
    private int bookInfoId;

    private String bookType;

    private String bookTypeName;

    private int bookTypeCode;

    private String bookName;

    private String bookPrice;

    private String bookAuthor;

    private String bookPublisher;

    private String createBy;

    private int bookCopyNumber;
}
