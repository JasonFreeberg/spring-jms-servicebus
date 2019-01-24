package org.apache.qpid.jms.spring.boot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class ExceptionHandler implements ErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public void handleError(Throwable t) {
        LOG.error("Error in listener", t);
    }
}