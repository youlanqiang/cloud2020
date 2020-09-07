package top.youlanqiang.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced //赋予负载均衡的能力，只有添加了这个注解才可以RestTemplate才支持根据服务名来调用对应的服务
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
