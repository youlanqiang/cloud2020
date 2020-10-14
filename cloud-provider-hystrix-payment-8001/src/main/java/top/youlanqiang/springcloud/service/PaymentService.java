package top.youlanqiang.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfoOk(Integer id){
        return "线程池:"+Thread.currentThread().getName()+" id:"+id;
    }

    public String paymentInfoTimeOut(Integer id){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+" id:"+id+" 耗时3秒";
    }

}
