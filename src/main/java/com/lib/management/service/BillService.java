package com.lib.management.service;

import com.lib.management.dto.BookBill;
import com.lib.management.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface BillService {
    List<BookBill> getBookBillOnlyByPage(int page);

    List<BookBill> getBookBillByDate(int page,
                                     int beginYear,int beginMonth,int beginDay,
                                     int endYear,int endMonth,int endDay);

    List<User> getPermitBill(int beginYear,int beginMonth,int beginDay,
                             int endYear,int endMonth,int endDay,int page);

    BigDecimal getBillNumberByDate(int beginYear,int beginMonth,int beginDay,
                                   int endYear,int endMonth,int endDay);

    BigDecimal getBillFineNumberByDate(int beginYear,int beginMonth,int beginDay,
                                       int endYear,int endMonth,int endDay);

    BigDecimal getBillPermitNumberByDate(int beginYear,int beginMonth,int beginDay,
                                         int endYear,int endMonth,int endDay);
}
