package top.youlanqiang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.springcloud.entities.CommonResult;
import top.youlanqiang.springcloud.entities.Payment;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {

    @PostMapping("/create")
    CommonResult<Payment> create(@RequestBody Payment payment);

    @GetMapping("/get/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id) ;


    @GetMapping("/feign/timeout")
    String paymentTimeout();
}
