package cn.wjx.springcloud.controller;

import cn.wjx.springcloud.service.IMessageProvider;
import cn.wjx.springcloud.service.impl.MessageProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @RequestMapping(value = "/sendMsg",method = RequestMethod.GET)
    public String sendMessage(){
        return messageProvider.send();
    }
}
