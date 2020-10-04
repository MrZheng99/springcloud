package com.zj.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * yml配置
     *
     * hystrix:
     *   command:
     *     default:
     *       execution:
     *         isolation:
     *           thread:
     *             timeoutInMilliseconds: 2000
     *     test1:
     *       execution:
     *         isolation:
     *           thread:
     *             timeoutInMilliseconds: 3000
     *
     */
    @GetMapping("/m1")
    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")
            } //默认1s
    )
    public String m1(){
        return  restTemplate.getForObject("http://product-server/product/findOne",String.class);
    }

    @GetMapping("/m2")
    @HystrixCommand
    public String m2(){
        return  restTemplate.getForObject("http://product-server/product/findOne",String.class);
    }
    @GetMapping("/m3")
    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),//允许熔断最小请求数
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"),//窗口期时长
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60"),//错误率这么高以上熔断
                    @HystrixProperty(name="circuitBreaker.enabled", value="true")//允许熔断
            }
    )
    public String m3(){
        return  restTemplate.getForObject("http://product-server/product/findOne",String.class);
    }
    public String fallback(){
        return "超时给老子滚 别访问 尼玛的";
}
    public String defaultFallback(){
        return "默认的 别访问 尼玛的";
    }
}
