package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import com.tkachuk.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api("End point to send mails asynchronously")
public class MailController {
    private Logger LOGGER = LoggerFactory.getLogger(MailController.class);
    @Autowired
    private MessageProducer messageProducer;

    /**
     * @param message Mail pojo
     * @return acknowledgement that the request for mail has been accepeted
     */
    @ApiOperation(value = "Send mails",response = String.class, consumes="JSON", tags="mail")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 202, message = "Send Email request accepted"),
            }
    )
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String send(@RequestBody Mail message) {
        messageProducer.sendMessage(message);
        LOGGER.info("Received message in rest:" + message);
        return "Request Accepted!";
    }
}
