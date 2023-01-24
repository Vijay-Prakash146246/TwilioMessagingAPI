package com.Vijay.controller;
import com.Vijay.model.MessageModel;
import com.Vijay.service.TwilloMessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/twillo")
public class smsController
{
    @Autowired
    private TwilloMessageSenderService twilloService;

    @PostMapping("/sendSMS")
    public String sendSMSByTwillo(@RequestBody MessageModel messageRequest) {
        String sendMessageResponse = twilloService.sendMessage(messageRequest);
        return sendMessageResponse;
    }
}
