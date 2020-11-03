package top.youlanqiang.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker //启动Hystrix的熔断机制
@EnableEurekaClient
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
