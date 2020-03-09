package cn.wjx.springcloud.service.impl;

import cn.wjx.springcloud.dao.PaymentDao;
import cn.wjx.springcloud.entities.Payment;
import cn.wjx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
