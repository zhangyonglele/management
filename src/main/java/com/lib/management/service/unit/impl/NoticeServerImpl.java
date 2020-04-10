package com.lib.management.service.unit.impl;

import com.lib.management.dto.BroadcastTitleOnly;
import com.lib.management.dto.NoticeForShow;
import com.lib.management.model.LibrarianBroadcast;
import com.lib.management.service.BroadcastTitleOnlyService;
import com.lib.management.service.LibrarianBroadcastService;
import com.lib.management.service.NoticeForShowService;
import com.lib.management.service.unit.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServerImpl implements NoticeService {
    @Resource
    private LibrarianBroadcastService broadcastService;

    @Resource
    private BroadcastTitleOnlyService broadcastTitleOnlyService;

    @Resource
    private NoticeForShowService noticeForShowService;

    @Override
    public boolean addNotice(LibrarianBroadcast broadcast) {
        return broadcastService.addNewBroadcast(broadcast);
    }

    @Override
    public List<BroadcastTitleOnly> getBroadcastListByPage(int page) {
        return broadcastTitleOnlyService.getBroadcastListByPage(page);
    }

    @Override
    public List<BroadcastTitleOnly> getBroadcastForSlideshow() {
        return broadcastTitleOnlyService.getBroadcastForSlideshow();
    }

    @Override
    public NoticeForShow getNoticeDetailById(int broadcastId) {
        return noticeForShowService.getNoticeForDetail(broadcastId);
    }

    @Override
    public boolean updateNotice(LibrarianBroadcast broadcast) {
        return broadcastService.updateBroadcast(broadcast);
    }
}
