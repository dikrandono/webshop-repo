package com.finalist.config;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.finalist.view.emailservice.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfig.class)
@ActiveProfiles("hsql")
public class TestSpringMail {

	@Autowired
	private EmailService emailService;
	
	
	@Test
	public void itShouldSendMail() {
		emailService.sendMail("dikran.dono@finalist.nl", "Test Email Service" , "Email text");
		
	  }
      
		
	 

}
