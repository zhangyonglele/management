package com.lib.management.service.unit;

import com.lib.management.dto.BroadcastTitleOnly;
import com.lib.management.dto.NoticeForShow;
import com.lib.management.model.LibrarianBroadcast;

import java.util.List;

public interface NoticeService {
    boolean addNotice(LibrarianBroadcast broadcast);

    List<BroadcastTitleOnly> getBroadcastListByPage(int page);

    List<BroadcastTitleOnly> getBroadcastForSlideshow();

    NoticeForShow getNoticeDetailById(int broadcastId);

    boolean updateNotice(LibrarianBroadcast broadcast);
}
