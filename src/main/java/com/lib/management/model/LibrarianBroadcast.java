package com.lib.management.model;

import java.util.Date;

public class LibrarianBroadcast {
    private Integer broadcastId;

    private String broadcastContains;

    private String createBy;

    private Date createTime;

    public Integer getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Integer broadcastId) {
        this.broadcastId = broadcastId;
    }

    public String getBroadcastContains() {
        return broadcastContains;
    }

    public void setBroadcastContains(String broadcastContains) {
        this.broadcastContains = broadcastContains == null ? null : broadcastContains.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}