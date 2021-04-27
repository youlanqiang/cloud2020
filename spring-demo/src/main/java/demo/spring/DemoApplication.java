package demo.spring;

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
    }

}
