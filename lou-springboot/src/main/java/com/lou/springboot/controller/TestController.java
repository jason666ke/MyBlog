package com.lou.springboot.controller;

import com.lou.springboot.entity.SaleGoods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "/get/httpmessageconverter", method = RequestMethod.GET)
    @ResponseBody
    public SaleGoods httpMessageConverterTest() {
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setGoodsName("huawei mobile phone");
        saleGoods.setId(1);
        saleGoods.setOnSale(true);
        saleGoods.setType(1);
        saleGoods.setWeight(300);
        return saleGoods;
    }

    @RequestMapping(value = "/test/httpmessageconverter", method = RequestMethod.POST)
    @ResponseBody
    public SaleGoods httpMessageConverterTest2(@RequestBody SaleGoods saleGoods) {
        System.out.println(saleGoods.toString());
        saleGoods.setType(saleGoods.getType() + 1);
        saleGoods.setGoodsName("goods Name: " + saleGoods.getGoodsName());
        return saleGoods;
    }
}