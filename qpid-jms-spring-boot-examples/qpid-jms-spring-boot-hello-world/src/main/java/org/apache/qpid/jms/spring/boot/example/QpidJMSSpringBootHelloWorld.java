package org.apache.qpid.jms.spring.boot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Simple Hello World example that sends and receives a message
 */
@SpringBootApplication
@EnableJms
public class QpidJMSSpringBootHelloWorld {

    @Autowired
    ExceptionHandler errorHandler;

    // Allows the JMS-annotations to discover the exception handler class.
    @Bean
    public  DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory, ExceptionHandler errorHandler) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(errorHandler);
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(QpidJMSSpringBootHelloWorld.class, args);
    }
}
