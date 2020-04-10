package com.lib.management.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * notice_for_show
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