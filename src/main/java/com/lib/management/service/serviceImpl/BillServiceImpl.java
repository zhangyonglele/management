package com.lib.management.service.serviceImpl;

import com.lib.management.dto.BookBill;
import com.lib.management.mapper.BookBillMapper;
import com.lib.management.mapper.UserMapper;
import com.lib.management.model.User;
import com.lib.management.service.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl implements BillService {
    @Resource
    private BookBillMapper bookBillMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<BookBill> getBookBillOnlyByPage(int page) {
        return bookBillMapper.getBillRecordByPage((page-1)*10);
    }

    @Override
    public List<BookBill> getBookBillByDate(int page, int beginYear, int beginMonth, int beginDay, int endYear, int endMonth, int endDay) {
        String beginDateString = beginYear + "-" + beginMonth + "-" + beginDay + " 00:00:00";
        String endDateString = endYear + "-" + endMonth + "-" + endDay +" 00:00:00";
        Map<String,Object> map = new HashMap<>();
        map.put("begin",beginDateString);
        map.put("end",endDateString);
        map.put("page",(page - 1) * 10);
        return bookBillMapper.getBillRecordByDate(map);
    }

    @Override
    public List<User> getPermitBill(int beginYear, int beginMonth, int beginDay, int endYear, int endMonth, int endDay,int page) {
        String beginDateString = beginYear + "-" + beginMonth + "-" + beginDay + " 00:00:00";
        String endDateString = endYear + "-" + endMonth + "-" + endDay +" 00:00:00";
        Map<String,Object> map = new HashMap<>();
        map.put("begin",beginDateString);
        map.put("end",endDateString);
        map.put("page",(page - 1) * 10);
        return userMapper.selectUserRegisterByDate(map);
    }

    @Override
    public BigDecimal getBillNumberByDate(int beginYear, int beginMonth, int beginDay, int endYear, int endMonth, int endDay) {
        String beginDateString = beginYear + "-" + beginMonth + "-" + beginDay + " 00:00:00";
        String endDateString = endYear + "-" + endMonth + "-" + endDay +" 00:00:00";
        Map<String,Object> map = new HashMap<>();
        map.put("begin",beginDateString);
        map.put("end",endDateString);
        return bookBillMapper.getBillNumberByDate(map);
    }

    @Override
    public BigDecimal getBillFineNumberByDate(int beginYear, int beginMonth, int beginDay, int endYear, int endMonth, int endDay) {
        String beginDateString = beginYear + "-" + beginMonth + "-" + beginDay + " 00:00:00";
        String endDateString = endYear + "-" + endMonth + "-" + endDay +" 00:00:00";
        Map<String,Object> map = new HashMap<>();
        map.put("begin",beginDateString);
        map.put("end",endDateString);
        return bookBillMapper.getBillFineNumber(map);
    }

    @Override
    public BigDecimal getBillPermitNumberByDate(int beginYear, int beginMonth, int beginDay, int endYear, int endMonth, int endDay) {
        String beginDateString = beginYear + "-" + beginMonth + "-" + beginDay + " 00:00:00";
        String endDateString = endYear + "-" + endMonth + "-" + endDay +" 00:00:00";
        Map<String,Object> map = new HashMap<>();
        map.put("begin",beginDateString);
        map.put("end",endDateString);
        return bookBillMapper.getBillPermitNumber(map);
    }
}
