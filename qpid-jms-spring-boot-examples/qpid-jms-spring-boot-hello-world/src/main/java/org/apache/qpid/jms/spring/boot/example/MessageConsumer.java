package org.apache.qpid.jms.spring.boot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "<your-queue-name>")
    public void processMsg(String message) {
        LOG.info("============= Received: " + message + " =============\n");
    }
}
