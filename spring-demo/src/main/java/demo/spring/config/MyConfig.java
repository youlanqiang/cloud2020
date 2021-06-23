package demo.spring.config;

import demo.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Spring 5.2 新特性 proxyBeanMethods 代理bean方法
 *
 * proxyBeanMethods 为 true 表示 full模式
 * 外部无论对配置类中的组件注册方法调用多少次都是之前注册容器中的单实例对象
 *
 * proxyBeanMethods 为 false 表示 lite模式
 * 每次调用方法都是新的Bean，用来解决Bean与Bean之间的依赖关系
 *
 * @author youlanqiang
 * created in 2021/6/23 23:05
 */
@Configuration(proxyBeanMethods = true) //告诉Spring这是一个配置类
public class MyConfig {

    @Bean //给容器中添加组件，以方法名作为组件的ID，返回类型就是组件类型，返回值就是组件在容器中的实例
    public User user(){
        return new User("user", 10);
    }


    @Bean("tom") //设置组件名称
    public User user1(){
        return new User("tom", 10);
    }
}
