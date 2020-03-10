package cn.wjx.springcloud.controller;

import cn.wjx.springcloud.entities.CommonResult;
import cn.wjx.springcloud.entities.Payment;
import cn.wjx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("payment/create")
    public CommonResult addPaymentInfo(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        log.info("添加数据影响行数："+result+"O(∩_∩)O哈哈~! 端口号："+port);
        if(result>0){
            return new CommonResult(200,"success","添加数据成功");
        }else {
            return new CommonResult(404,"error");
        }
    }

    @GetMapping("payment/queryById/{id}")
    public CommonResult getPaymentInfoById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据结果："+payment+" 端口号："+port);
        if(payment!=null){
            return new CommonResult(200,"success"+port,payment);
        }else {
            return new CommonResult(404,"error");
        }
    }

    @GetMapping("/getDiscovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service :
                services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances){
            log.info("服务id:"+instance.getServiceId()+"\tIP地址："+instance.getHost()+"\t端口号:"+instance.getPort()+"url:"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public Integer getPort(){
        return port;
    }
}
