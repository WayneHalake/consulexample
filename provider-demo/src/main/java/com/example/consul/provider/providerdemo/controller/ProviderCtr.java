package com.example.consul.provider.providerdemo.controller;

import com.example.consul.provider.providerdemo.service.ProviderSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderCtr {

    @Autowired
    private ProviderSer providerSer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discoveryClient")
    public String discoveryClient(){
        List<String> services = discoveryClient.getServices();
        return services.toString();
    }

    @GetMapping("/sayHello")
    public String sayHello(){
        return providerSer.sayHello();
    }


    @GetMapping("/delaySayHello")
    public String delaySayHello() throws Exception{
        //添加睡眠时间，测试Hystrix消费降级
        Thread.sleep(5000L);
        return providerSer.sayHello();
    }
}