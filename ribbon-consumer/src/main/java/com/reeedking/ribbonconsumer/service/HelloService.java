package com.reeedking.ribbonconsumer.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    public String helloFallback() {
        return "error";
    }
}
