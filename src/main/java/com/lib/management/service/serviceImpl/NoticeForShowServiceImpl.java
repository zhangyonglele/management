package com.lib.management.service.serviceImpl;

import com.lib.management.dto.NoticeForShow;
import com.lib.management.mapper.NoticeForShowMapper;
import com.lib.management.service.NoticeForShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NoticeForShowServiceImpl implements NoticeForShowService {
    @Resource
    private NoticeForShowMapper noticeForShowMapper;
    @Override
    public NoticeForShow getNoticeForDetail(int broadcastId) {
        return noticeForShowMapper.selectNoticeDetailById(broadcastId);
    }
}
