package com.lib.management.dto;

import lombok.Data;

/**
 * 部分淘汰，新功能请使用BookWithPic开发
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
