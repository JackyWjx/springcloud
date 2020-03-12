package cn.wjx.springcloud.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "8001异常了，告诉你一声";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "8001异常了，告诉你一声";
    }
}
