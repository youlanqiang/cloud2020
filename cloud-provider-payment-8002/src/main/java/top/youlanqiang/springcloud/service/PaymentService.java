package top.youlanqiang.springcloud.service;


import top.youlanqiang.springcloud.entities.Payment;


public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
