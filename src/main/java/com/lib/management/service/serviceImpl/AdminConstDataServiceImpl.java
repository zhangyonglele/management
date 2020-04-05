package com.lib.management.service.serviceImpl;

import com.lib.management.mapper.AdminConstDataMapper;
import com.lib.management.model.AdminConstData;
import com.lib.management.service.AdminConstDataService;
import com.lib.management.util.MyDateFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class AdminConstDataServiceImpl implements AdminConstDataService {
    @Resource
    AdminConstDataMapper adminConstDataMapper;

    @Override
    public boolean updateAdminConstData(String constKey, BigDecimal num) {
        /*String dateS = MyDateFormat.dateFormat.format(new Date());
        *//*Date date = null;
        try {
            date = MyDateFormat.dateFormat.parse(dateS);
        }catch (Exception e){
            e.printStackTrace();
        }*//*
        AdminConstData adminConstData = new AdminConstData(constKey,num,1,null);*/
        return adminConstDataMapper.updateByPrimaryKey(constKey,num) > 0;
    }
}
