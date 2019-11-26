package com.consulexample.consumer.consumerdemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 该接口表示Feign的客户端接口定义
 * @FeignClient 注解来指定这个接口所要调用的服务名称
 */

@FeignClient("consul-provider")
@Component
public interface ConsumerSer {

    /**
     * consul-provider微服务中的接口
     * @return
     */
    @GetMapping("/provider/sayHello")
    String providerSayHello();
}
