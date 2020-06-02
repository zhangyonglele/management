package com.lib.management.service;

import com.lib.management.dto.ControlLogForShow;
import com.lib.management.model.BookControlLog;

import java.util.List;

public interface BookLogService {
    boolean addLog(BookControlLog log);

    List<ControlLogForShow> getControlLogByPage(int page);
}
