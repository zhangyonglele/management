package com.lib.management.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * control_log_for_show a view in database
 * @author 
 */
@Data
public class ControlLogForShow implements Serializable {
    /**
     * 操作日志id
     */
    private Integer logId;

    /**
     * 图书管理员用户名
     */
    private String bookManagerName;

    /**
     * 操作类型 1,添加书籍；2、删除书籍；3、添加书籍种类；4、移除书籍种类；5、添加书籍拷贝；6、移除书籍拷贝
     */
    private Integer logType;

    /**
     * 操作内容 书籍种类/书籍名称/某种书籍的第几份拷贝
     */
    private String optionContain;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}