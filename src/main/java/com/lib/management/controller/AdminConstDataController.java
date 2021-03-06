package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.service.AdminConstDataService;
import com.lib.management.util.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Slf4j
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
@RequestMapping("/admin/rules")
@RestController
public class AdminConstDataController {
    @Resource
    AdminConstDataService adminConstDataService;

    @PutMapping("{constKey}")
    //@LoginRequire("superAdmin")
    public UniversalResponseBody updateBorrowRules(@PathVariable("constKey") String key, BigDecimal values, HttpSession session){
        if(adminConstDataService.updateAdminConstData(key,values)){
            return new UniversalResponseBody(0,"success");
        }else {
            log.info("[WARN CHECK] constKey "+key+" value "+values);
            return  new UniversalResponseBody(-1,"error");
        }

    }
}
