package com.lib.management.mapper;

import com.lib.management.dto.NoticeForShow;

public interface NoticeForShowMapper {
    NoticeForShow selectNoticeDetailById(int broadcastId);
}