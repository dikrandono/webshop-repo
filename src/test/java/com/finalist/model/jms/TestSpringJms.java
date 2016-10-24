package com.finalist.model.jms;

import static org.junit.Assert.assertNotNull;

import java.net.URI;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


import com.finalist.config.TestSpringConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfig.class)
@ActiveProfiles("hsql")
public class TestSpringJms {

	@Autowired
	SpringJmsProducer springJmsProducer;
	
	@Autowired
	SpringJmsConsumer springJmsConsumer ;
	
	@Test
	public void itShouldTestJMS() throws Exception{
		
		BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		broker.start();
		String recievedmessage ;
		try {
			 //WHEN SEND
			springJmsProducer.sendMessage("Hi this is my jms message");

			//THEN RECIEVE
		    recievedmessage = springJmsConsumer.receiveMessage();
			System.out.println("itShouldTestRecieveJMS  receives " + recievedmessage );
			
		} finally {
			broker.stop();
		}

		assertNotNull(recievedmessage); 
	  }

}
