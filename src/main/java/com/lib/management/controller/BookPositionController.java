package com.lib.management.controller;

import com.lib.management.service.BookPositionService;
import com.lib.management.util.UniversalResponseBody;
import com.lib.management.dto.BookPosition;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"http://localhost:8081","*"})
public class BookPositionController {
    @Resource
    private BookPositionService bookPositionService;

    @GetMapping("/book/copy/{bookInfoId}/page/{page}")
    public UniversalResponseBody<List<BookPosition>> getBookCopyPositionInfoByBookInfoId(@PathVariable("bookInfoId")int bookInfoId,@PathVariable("page")int page){
        return new UniversalResponseBody<>(0,"success",bookPositionService.getBookPositionByBookInfoId(bookInfoId, page));
    }
}
