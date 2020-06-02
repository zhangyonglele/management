package com.lib.management.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * notice_for_show a view in database
 * @author 
 */
@Data
public class NoticeForShow implements Serializable {
    /**
     * 公告id
     */
    private Integer broadcastId;

    /**
     * 公告标题
     */
    private String broadcastTitle;

    /**
     * 公告内容
     */
    private String broadcastContains;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 公告封面
     */
    private String image;

    /**
     * 图书管理员用户名
     */
    private String bookManagerName;

    private static final long serialVersionUID = 1L;
}