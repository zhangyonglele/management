package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BroadcastTitleOnly;
import com.lib.management.mapper.BroadcastTitleOnlyMapper;
import com.lib.management.service.BroadcastTitleOnlyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BroadcastTitleOnlyServiceImpl implements BroadcastTitleOnlyService {
    @Resource
    private BroadcastTitleOnlyMapper broadcastTitleOnlyMapper;

    @Override
    public List<BroadcastTitleOnly> getBroadcastListByPage(int page) {
        return broadcastTitleOnlyMapper.selectBroadcastByPageOrderTimeDesc((page-1)*10);
    }

    @Override
    public List<BroadcastTitleOnly> getBroadcastForSlideshow() {
        return broadcastTitleOnlyMapper.selectForSlideshow();
    }
}
