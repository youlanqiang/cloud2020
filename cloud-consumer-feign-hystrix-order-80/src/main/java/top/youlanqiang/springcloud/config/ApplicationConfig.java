package top.youlanqiang.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }

}
