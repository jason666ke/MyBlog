package com.lou.springboot.controller;

import com.lou.springboot.service.TransactionTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TransactionTestController {

    @Resource
    private TransactionTestService transactionTestService;

    // transaction controller test
    @GetMapping("/transactionTest")
    @ResponseBody
    public String transactionTest() {
        // no @transactional
        transactionTestService.test1();
        // add @transactional
        transactionTestService.test2();

        return "Test done";
    }

}
