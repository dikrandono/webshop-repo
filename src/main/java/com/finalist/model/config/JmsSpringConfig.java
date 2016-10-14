package com.finalist.model.config;

import javax.jms.Destination;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE))
public class JmsSpringConfig {

	
	public JmsSpringConfig() {
	}
	
	@Bean
    public ActiveMQConnectionFactory connectionFactory() {
		
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }
	
	
	@Bean
    public JmsTemplate jmsTemplate() {
		
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(messageDestination());
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setReceiveTimeout(1000);
        return jmsTemplate;
        
    }
	
	
	@Bean
    public Destination messageDestination() {
		
		return new ActiveMQQueue("messageQueue1");
	}

}
