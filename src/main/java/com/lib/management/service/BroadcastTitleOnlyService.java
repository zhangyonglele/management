package com.lib.management.service;

import com.lib.management.dto.BroadcastTitleOnly;

import java.util.List;

public interface BroadcastTitleOnlyService {
    List<BroadcastTitleOnly> getBroadcastListByPage(int page);

    List<BroadcastTitleOnly> getBroadcastForSlideshow();
}
