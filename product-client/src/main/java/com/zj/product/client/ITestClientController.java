package com.zj.product.client;

import com.zj.product.dto.ProductInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
@FeignClient(name = "product-server",fallback = ITestClientController.MFallback.class)//设置为feginClient
public interface ITestClientController {
    @GetMapping("/product/findAll")
    public List<ProductInfoDTO> findAllForTest();
    @GetMapping("/product/findOne")
    public ProductInfoDTO findOneForTest();
    @Component
    public static class MFallback implements ITestClientController{
        @Override
        public List<ProductInfoDTO> findAllForTest() {
            return Collections.emptyList();
        }

        @Override
        public ProductInfoDTO findOneForTest() {
            return new ProductInfoDTO();
        }
    }
}
