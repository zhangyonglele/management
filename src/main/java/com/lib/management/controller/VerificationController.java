package com.lib.management.controller;

import com.lib.management.filter.annotation.LoginRequire;
import com.lib.management.util.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verification")
public class VerificationController {

    @GetMapping("/librarian")
    @LoginRequire("librarian")
    public UniversalResponseBody librarian(){
        return new UniversalResponseBody(0,"success");
    }

    
}
