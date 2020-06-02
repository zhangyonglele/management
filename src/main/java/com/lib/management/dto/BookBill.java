package com.lib.management.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lib.management.util.Decimal2Serializer;
import lombok.Data;

/**
 * book_bill is a view in database
 * @author 
 */
@Data
public class BookBill implements Serializable {
    /**
     * 日志id
     */
    private Integer logId;

    /**
     * 被借图书id
     */
    private Integer bookId;

    /**
     * 用户名
     */
    private String bookBorrowBy;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书出版社
     */
    private String bookPublisher;

    /**
     * 借阅状态 0，在借阅期；1，已经归还；2，超期；3，超期归还
     */
    private Integer bookBorrowStatus;

    /**
     * 保证金缴费状态 1,已缴；0，未缴
     */
    private Integer permitMoneyStatus;

    /**
     * 保证金金额
     */
    @JsonSerialize(using = Decimal2Serializer.class)
    private BigDecimal permitMoneyNumber;

    /**
     * 罚金存在状态 0，不存在；1，存在
     */
    private Integer fineStatus;

    /**
     * 罚金金额
     */
    @JsonSerialize(using = Decimal2Serializer.class)
    private BigDecimal fineNumber;

    /**
     * 借阅时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookBorrowTime;

    private static final long serialVersionUID = 1L;
}