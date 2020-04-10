package com.lib.management.dto.helper;

import com.lib.management.model.LibrarianBroadcast;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeHelper {

    /**
     * 公告标题
     */
    private String broadcastTitle;

    /**
     * 公告内容
     */
    private String broadcastContains;


    /**
     * 公告封面
     */
    private String image;

    public LibrarianBroadcast toBroadcast(){
        LibrarianBroadcast temp = new LibrarianBroadcast();
        temp.setBroadcastContains(this.broadcastContains);
        temp.setCreateTime(new Date());
        temp.setBroadcastTitle(this.broadcastTitle);
        temp.setImage(image);
        return temp;
    }
}
