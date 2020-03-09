package cn.wjx.springcloud.service;

import cn.wjx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int addPayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
