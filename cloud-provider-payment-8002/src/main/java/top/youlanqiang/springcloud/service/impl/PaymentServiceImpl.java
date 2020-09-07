package top.youlanqiang.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.youlanqiang.springcloud.dao.PaymentDao;
import top.youlanqiang.springcloud.entities.Payment;
import top.youlanqiang.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
