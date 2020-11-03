package top.youlanqiang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.youlanqiang.springcloud.service.PaymentFeignService;



import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderHystrixController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/hystrix/ok/{id}")
    @HystrixCommand //使用默认回调,注意返回类型，需要全局通用
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfoOk(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutMethod", commandProperties = {
            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value="3000")
    })
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfoTimeOut(id);
    }

    public String paymentInfoTimeOutMethod(@PathVariable("id") Integer id){
        return "消费者调用服务降级.";
    }


    //global fallback 全局
    public String defaultFallback(){
        return "默认服务降级.";
    }

}
