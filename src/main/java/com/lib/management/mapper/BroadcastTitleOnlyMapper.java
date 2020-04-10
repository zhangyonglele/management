package com.lib.management.mapper;

import com.lib.management.dto.BroadcastTitleOnly;

import java.util.List;

public interface BroadcastTitleOnlyMapper {
    List<BroadcastTitleOnly> selectBroadcastByPageOrderTimeDesc(int pageNumber);

    List<BroadcastTitleOnly> selectForSlideshow();
}
