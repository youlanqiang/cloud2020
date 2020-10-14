package top.youlanqiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.springcloud.service.PaymentFeignService;



import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderHystrixController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfoOk(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfoTimeOut(id);
    }



}
