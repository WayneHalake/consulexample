package com.consulexample.consumer.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //开启微服务发现客户端
@EnableFeignClients //开启扫描Spring Cloud Feign客户端的功能

//开启 hystrix服务消费容错 也可以直接使用@SpringCloudApplication
@EnableHystrix
@EnableCircuitBreaker
public class ConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemoApplication.class, args);
    }

}
