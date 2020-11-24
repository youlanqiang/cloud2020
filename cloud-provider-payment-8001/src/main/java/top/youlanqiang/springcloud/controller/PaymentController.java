package top.youlanqiang.springcloud.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.springcloud.entities.CommonResult;
import top.youlanqiang.springcloud.entities.Payment;
import top.youlanqiang.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果:" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功. server-port:"+serverPort,payment);
        } else {
            return new CommonResult<>(500, "插入数据失败.");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果:" + result);
        if (result != null) {
            return new CommonResult<>(200, "成功.",result);
        } else {
            return new CommonResult<>(500, "插入数据失败.");
        }
    }

    @GetMapping("/feign/timeout")
    public String paymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String zipkin(){
        return "result for zipkin";
    }

}
