package org.apache.qpid.jms.spring.boot.autoconfigure;

import javax.jms.ConnectionFactory;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class that is responsible for creating and configuration the resulting
 * Qpid JMS ConnectionFactory instance.
 */
@Configuration
@ConditionalOnMissingBean(ConnectionFactory.class)
public class QpidJMSConnectionFactoryConfiguration {

    @Bean
    public JmsConnectionFactory jmsConnectionFactory(QpidJMSProperties properties) {
        return new QpidJMSConnectionFactoryFactory(properties)
            .createConnectionFactory(JmsConnectionFactory.class);
    }
}
