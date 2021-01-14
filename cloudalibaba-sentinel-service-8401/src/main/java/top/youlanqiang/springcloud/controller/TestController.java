package top.youlanqiang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author youlanqiang
 * created in 2020/12/13 9:52
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }

    @GetMapping("/testD")
    public String testD(){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        int i = 10/0;
        return "-----testD";
    }


    @GetMapping("/testE")
    public String testE(){
        log.info("testE 测试异常数");
        int i = 10/0;
        return "-----testD";
    }


    @GetMapping("/res")
    @SentinelResource(value = "res",blockHandler = "resBlock")
    public String res(){
        return "res";
    }

    public String resBlock(){
        return "res - block";
    }
}
