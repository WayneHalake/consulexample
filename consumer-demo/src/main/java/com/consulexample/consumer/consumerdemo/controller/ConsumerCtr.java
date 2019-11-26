package com.consulexample.consumer.consumerdemo.controller;

import com.consulexample.consumer.consumerdemo.service.ConsumerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/consumer")
@RestController
public class ConsumerCtr {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ConsumerSer consumerSer;

    /**
     * 普通的url调用
     * @return
     */
    @GetMapping("/cell")
    public String cell(){
        List<String> services = discoveryClient.getServices();
        for(String service: services){
            System.out.println(service);
        }

        ServiceInstance instance = loadBalancerClient.choose("consul-provider");
        System.out.println("Hostname:"+ instance.getHost());
        System.out.println("Service name:"+ instance.getInstanceId());
        System.out.println("uri:"+ instance.getUri());
        return restTemplate.getForObject(instance.getUri()+"/provider/sayHello", String.class);
    }

    /**
     * Feign客户端调用
     * @return
     */
    @GetMapping("/feignCell")
    public String feignCell(){
        return consumerSer.providerSayHello();
    }

}
