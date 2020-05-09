package com.lib.management.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * librarian_broadcast
 * @author 
 */
@Data
public class LibrarianBroadcast implements Serializable {
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
     * 公告创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 公告封面
     */
    private String image;

}