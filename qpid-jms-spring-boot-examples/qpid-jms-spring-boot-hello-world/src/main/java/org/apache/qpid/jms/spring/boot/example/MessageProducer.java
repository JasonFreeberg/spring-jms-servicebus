package org.apache.qpid.jms.spring.boot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    public JmsTemplate jmsTemplate;

    @Override
    public void run(String... strings) throws Exception {
        final String messageText = "Hello World";
        LOG.info("============= Sending: " + messageText + " =============\n");
        sendMessage(messageText);
    }

    public void sendMessage(String payload) {
        this.jmsTemplate.convertAndSend("<your-queue-name>", payload);
    }
}