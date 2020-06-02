package com.lib.management.mapper;

import com.lib.management.dto.BookBill;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BookBillMapper {
    List<BookBill> getBillRecordByDate(Map<String,Object> data);

    List<BookBill> getBillRecordByPage(int page);

    BigDecimal getBillNumberByDate(Map<String,Object> data);

    BigDecimal getBillFineNumber(Map<String ,Object> data);

    BigDecimal getBillPermitNumber(Map<String,Object> data);
}