package com.lib.management.mapper;

import com.lib.management.dto.ControlLogForShow;

import java.util.List;

public interface ControlLogForShowMapper {
    List<ControlLogForShow> selectLogByPage(int page);
}