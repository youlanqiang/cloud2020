package top.youlanqiang.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RequestMapping("/consumer")
public class OrderController {

    public static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consul")
    public String consul(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }


}

