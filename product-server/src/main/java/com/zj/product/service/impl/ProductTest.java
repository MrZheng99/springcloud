package com.zj.product.service.impl;

import com.zj.product.dao.IFlowerDao;
import com.zj.product.dto.ProductInfoDTO;
import com.zj.product.service.IProductTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductTest implements IProductTest {
    @Autowired
    IFlowerDao dao;
    @Override
    public List<ProductInfoDTO> findAll() {

           return dao.findAllForTest();

    }
    @Override
    public ProductInfoDTO findOne() {

            return dao.findOneForTest();}

}
