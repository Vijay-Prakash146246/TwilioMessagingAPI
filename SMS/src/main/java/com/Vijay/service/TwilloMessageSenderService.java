package com.Vijay.service;
import com.Vijay.model.MessageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.Message.Status;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class TwilloMessageSenderService
{
    private static final Logger logger = LoggerFactory.getLogger(TwilloMessageSenderService.class);

    @Value("${accountSID}")
    private String accountSID;

    @Value("${accountAuthToken}")
    private String accountAuthToken;

    @Value("${twilloSenderNumber}")
    private String twilloSenderNumber;

    public String sendMessage(MessageModel messageRequest) {
        try {
            Twilio.init(accountSID, accountAuthToken);

            String smsText = messageRequest.getSmsText();
            String mobileNumber = messageRequest.getMobileNumber();

            PhoneNumber recieverPhoneNumber = new PhoneNumber(mobileNumber);
            PhoneNumber senderTwilloPhoneNumber = new PhoneNumber(twilloSenderNumber);

            MessageCreator creator = com.twilio.rest.api.v2010.account.Message.creator(recieverPhoneNumber, senderTwilloPhoneNumber, smsText);
            Message create = creator.create();

            BigDecimal billingAmount = create.getPrice();
            Status status = create.getStatus();


            logger.info("Message Send Succesfully to the number " + mobileNumber);
            return "Message Send Succesfully";
        } catch (Exception e) {
            logger.error("Exception in sendMessage Method " + e);
            return "Message Send Fail";
        }

    }
}
