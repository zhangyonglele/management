package com.lib.management.model;

import java.io.Serializable;
import lombok.Data;

/**
 * book_picture
 * @author 
 */
@Data
public class Picture implements Serializable {
    /**
     * 图片主键
     */
    private Integer pictureId;

    private String pictureUrl;

    private Integer pictureBookId;

    private static final long serialVersionUID = 1L;
}