package top.youlanqiang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
@RequestMapping("/payment/hystrix")
public interface PaymentFeignService {

    @GetMapping("/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
