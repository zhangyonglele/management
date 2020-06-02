package com.lib.management.service.serviceImpl;

import com.lib.management.dto.ControlLogForShow;
import com.lib.management.mapper.BookControlLogMapper;
import com.lib.management.mapper.ControlLogForShowMapper;
import com.lib.management.model.BookControlLog;
import com.lib.management.service.BookLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookLogServiceImpl implements BookLogService {
    @Resource
    private BookControlLogMapper controlLogMapper;

    @Resource
    private ControlLogForShowMapper controlLogForShowMapper;

    @Override
    public boolean addLog(BookControlLog log) {
        boolean flag = false;
        try{
            controlLogMapper.insert(log);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<ControlLogForShow> getControlLogByPage(int page) {
        return controlLogForShowMapper.selectLogByPage((page - 1) * 10);
    }
}
