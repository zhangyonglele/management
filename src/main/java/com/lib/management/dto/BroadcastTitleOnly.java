package com.lib.management.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BroadcastTitleOnly implements Serializable {
    /**
     * 公告id
     */
    private Integer broadcastId;

    /**
     * 公告标题
     */
    private String broadcastTitle;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 公告封面
     */
    private String image;
}
