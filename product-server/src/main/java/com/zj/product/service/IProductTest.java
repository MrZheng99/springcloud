package com.zj.product.service;

import com.zj.product.dto.ProductInfoDTO;

import java.util.List;

public interface IProductTest {
    public List<ProductInfoDTO> findAll();
    public ProductInfoDTO findOne();
}
