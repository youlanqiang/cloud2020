package top.youlanqiang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youlanqiang
 * created in 2020/11/29 14:19
 */
@RestController
@RefreshScope
public class IndexController {


    @Value("${config.info}")
    private String value;

    @GetMapping("/info")
    public String getInfo(){
        return value;
    }
}
