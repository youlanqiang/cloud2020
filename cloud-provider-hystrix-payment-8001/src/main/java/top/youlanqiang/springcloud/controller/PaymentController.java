package top.youlanqiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.youlanqiang.springcloud.service.PaymentService;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentService.paymentInfoTimeOut(id);
    }

}
