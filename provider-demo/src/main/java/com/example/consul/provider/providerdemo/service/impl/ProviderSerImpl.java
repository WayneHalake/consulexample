package com.example.consul.provider.providerdemo.service.impl;

import com.example.consul.provider.providerdemo.service.ProviderSer;
import org.springframework.stereotype.Service;

@Service
public class ProviderSerImpl implements ProviderSer {

    @Override
    public String sayHello() {
        return "hello!";
    }
}
