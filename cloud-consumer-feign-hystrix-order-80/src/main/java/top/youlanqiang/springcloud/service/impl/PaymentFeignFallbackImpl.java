package top.youlanqiang.springcloud.service.impl;

import org.springframework.stereotype.Component;
import top.youlanqiang.springcloud.service.PaymentFeignService;

@Component
public class PaymentFeignFallbackImpl implements PaymentFeignService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "fallback info ok";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "fallback timeout";
    }
}
