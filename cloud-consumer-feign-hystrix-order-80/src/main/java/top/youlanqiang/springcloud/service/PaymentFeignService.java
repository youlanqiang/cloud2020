package top.youlanqiang.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.springcloud.service.impl.PaymentFeignFallbackImpl;


@Component
//统一使用 PaymentFeignFallbackImpl来处理 让客户端无法连接到服务端时也可以进行服务降级
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFeignFallbackImpl.class)
@RequestMapping("/payment/hystrix")
public interface PaymentFeignService {

    @GetMapping("/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
