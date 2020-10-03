package com.zj.product.controller;

import com.zj.product.dto.ProductInfoDTO;
import com.zj.product.service.IProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    IProductTest productTest;

    @GetMapping("/product/findAll")
    public List<ProductInfoDTO> findAllForTest(){
        return productTest.findAll();
    }
    @GetMapping("/product/findOne")
    public ProductInfoDTO findOneForTest(){
        try {
            Thread.sleep(930);
            return productTest.findOne();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      return new ProductInfoDTO("adda");
    }
}
