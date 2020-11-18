package top.youlanqiang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用配置的方式定义SpringGateway路由
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        //访问 localhost:9527/xx 会转发到 http://www.baidu.com/xx
        return builder.routes().route("path-sample",
                r->r.path("/xx").uri("http://www.baidu.com/xx")
        ).build();
    }

}
