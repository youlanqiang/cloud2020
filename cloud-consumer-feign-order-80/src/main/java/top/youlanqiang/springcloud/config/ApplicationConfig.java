package top.youlanqiang.springcloud.config;


import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }

}
