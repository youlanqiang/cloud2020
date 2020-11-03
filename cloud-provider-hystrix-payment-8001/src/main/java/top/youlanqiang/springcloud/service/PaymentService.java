package top.youlanqiang.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfoOk(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" id:"+id;
    }


    /**
     * 程序出现异常时，HystrixCommand会自动调用fallback的方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value="3000")
    })
    public String paymentInfoTimeOut(Integer id){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+" id:"+id+" 耗时3秒";
    }

    public String paymentInfoTimeOutHandler(Integer id){
        return "使用服务降级";
    }

}
