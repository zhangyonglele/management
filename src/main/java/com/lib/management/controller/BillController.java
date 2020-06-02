package com.lib.management.controller;

import com.lib.management.dto.BookBill;
import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.service.BillService;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BillController {
    @Resource
    private BillService billService;

    @GetMapping("/bill/date")
    @LoginRequire("librarian")
    public UniversalResponseBody getBookBillByDate(@RequestParam("beginYear")int beginYear,
                                                             @RequestParam("beginMonth")int beginMonth,
                                                             @RequestParam("beginDay")int beginDay,
                                                             @RequestParam("endYear")int endYear,
                                                             @RequestParam("endMonth")int endMonth,
                                                             @RequestParam("endDay")int endDay,
                                                             @RequestParam("page")int page){
        return new UniversalResponseBody<>(0,"success",billService.getBookBillByDate(page,beginYear,beginMonth,beginDay,endYear,endMonth,endDay));
    }

    @GetMapping("/bill/page/{page}")
    @LoginRequire("librarian")
    public UniversalResponseBody getBookBill(@PathVariable("page") int page){
        return new UniversalResponseBody(0,"success",billService.getBookBillOnlyByPage(page));
    }

    @GetMapping("/bill/total/date")
    @LoginRequire("librarian")
    public UniversalResponseBody getBillIncomeSum(@RequestParam("beginYear")int beginYear,
                                                  @RequestParam("beginMonth")int beginMonth,
                                                  @RequestParam("beginDay")int beginDay,
                                                  @RequestParam("endYear")int endYear,
                                                  @RequestParam("endMonth")int endMonth,
                                                  @RequestParam("endDay")int endDay){
        return new UniversalResponseBody(0,"success",billService.getBillNumberByDate(beginYear,beginMonth,beginDay,endYear,endMonth,endDay));
    }

    @GetMapping("/bill/fine/date")
    @LoginRequire("librarian")
    public  UniversalResponseBody getBillFineByDate(@RequestParam("beginYear")int beginYear,
                                                    @RequestParam("beginMonth")int beginMonth,
                                                    @RequestParam("beginDay")int beginDay,
                                                    @RequestParam("endYear")int endYear,
                                                    @RequestParam("endMonth")int endMonth,
                                                    @RequestParam("endDay")int endDay){
        return new UniversalResponseBody(0,"success",billService.getBillFineNumberByDate(beginYear,beginMonth,beginDay,endYear,endMonth,endDay));
    }

    @GetMapping("/bill/permit/date/{page}")
    @LoginRequire("librarian")
    public UniversalResponseBody getPermitByDate(@RequestParam("beginYear")int beginYear,
                                                 @RequestParam("beginMonth")int beginMonth,
                                                 @RequestParam("beginDay")int beginDay,
                                                 @RequestParam("endYear")int endYear,
                                                 @RequestParam("endMonth")int endMonth,
                                                 @RequestParam("endDay")int endDay,
                                                 @PathVariable("page")int page){
        return new UniversalResponseBody(0,"success",billService.getPermitBill(beginYear,beginMonth,beginDay,endYear,endMonth,endDay,page));
    }
}
