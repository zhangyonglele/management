package com.lib.management.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lib.management.util.Decimal2Serializer;
import lombok.Data;

/**
 * book_for_history
 * @author 
 */
@Data
public class BookForHistory implements Serializable {
    /**
     * 被借图书id
     */
    private Integer bookId;

    /**
     * 借阅人
     */
    private Integer bookBorrowBy;

    /**
     * 借阅时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookBorrowTime;

    /**
     * 归还时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookReturnTime;

    /**
     * 借阅状态 0，在借阅期；1，已经归还；2，超期；3，超期归还
     */
    private Integer bookBorrowStatus;

    /**
     * 罚金存在状态 0，不存在；1，存在
     */
    private Integer fineStatus;

    /**
     * 罚金金额
     */
    @JsonSerialize(using = Decimal2Serializer.class)
    private BigDecimal fineNumber;

    private static final long serialVersionUID = 1L;
}