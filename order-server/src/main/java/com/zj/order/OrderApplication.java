package com.zj.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringCloudApplication
@MapperScan("com.zj.order.dao")
@EnableFeignClients(basePackages = {"com.zj.product.client"})//启用这个包下面的feginClient
@ComponentScan({"com.zj.order","com.zj.product.client"})//扫描
@EnableHystrixDashboard//启用仪表盘
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

}
