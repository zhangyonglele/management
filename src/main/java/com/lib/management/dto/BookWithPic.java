package com.lib.management.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * book_with_pic
 * @author 
 */
@Data
public class BookWithPic implements Serializable {
    /**
     * 书的自有id
     */
    private Integer bookInfoId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 种类编号
     */
    private String bookTypeMark;

    /**
     * 种类中文名称
     */
    private String bookTypeName;

    /**
     * 书在种类内部编号
     */
    private Integer bookTypeCode;

    /**
     * 书价
     */
    private String bookPrice;

    /**
     * 书作者
     */
    private String bookAuthor;

    /**
     * 书出版社
     */
    private String bookPublisher;

    /**
     * 该书的副本数
     */
    private Integer bookCopyNumber;

    private String pictureUrl;

    private String bookManagerName;

    private static final long serialVersionUID = 1L;
}