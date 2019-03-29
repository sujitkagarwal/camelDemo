package com.example.camel.demo.camelDemo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Authur : sujitagarwal
 * Created: 29/03/19.
 */
@EnableJms
@Configuration
public class JmsConfig {


    @Value("${activemq.broker.url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory getFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }


    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        return messageConverter;

    }

    public JmsListenerContainerFactory<?> queueListnerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory);
        jmsListenerContainerFactory.setMessageConverter(messageConverter());
        return jmsListenerContainerFactory;
    }

    @Bean("activemq")
    public ActiveMQComponent getActiveMQComponent(ActiveMQConnectionFactory activeMQConnectionFactory) {
        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
        activeMQComponent.setConnectionFactory(activeMQConnectionFactory);
        return activeMQComponent;
    }


}
