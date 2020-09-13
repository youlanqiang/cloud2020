package top.youlanqiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.springcloud.entities.CommonResult;
import top.youlanqiang.springcloud.entities.Payment;
import top.youlanqiang.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
      return paymentFeignService.create(payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return paymentFeignService.get(id);
    }


    @GetMapping("/feign/timeout")
    public String paymentTimeout(){
        //openfeign 默认等待一秒钟
        return paymentFeignService.paymentTimeout();
    }

}
