package demo.spring;

import demo.spring.bean.User;
import demo.spring.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author youlanqiang
 * created in 2021/4/28 3:29
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {


    public static void main(String[] args) {
        //1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

        //2.查看容器里的组件
        String names[] = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3. 从容器中获取组件
        User user = run.getBean("user", User.class);

        // 如果 @Configuration(proxyBeanMethods = true)代理对象调用方法
        // SpringBoot总会检查这个组件是否存在容器
        // 保持组件单实例
        MyConfig config = run.getBean(MyConfig.class);
        System.out.println(config.user() == config.user());
    }

}
