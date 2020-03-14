package com.lib.management.model;

import java.util.Date;

public class BookControlLog {
    private Integer logId;

    private Integer logType;

    private String optionContain;

    private Integer updateBy;

    private Date updateTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getOptionContain() {
        return optionContain;
    }

    public void setOptionContain(String optionContain) {
        this.optionContain = optionContain == null ? null : optionContain.trim();
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}