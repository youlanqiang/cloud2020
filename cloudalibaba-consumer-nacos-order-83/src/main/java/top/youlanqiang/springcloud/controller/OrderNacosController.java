package top.youlanqiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author youlanqiang
 *
 */
@RestController
@Slf4j
public class OrderNacosController {


    @Resource
    RestTemplate restTemplate;

    String url = "http://nacos-payment-provider";

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url+"/payment/nacos/"+id, String.class);
    }
}
