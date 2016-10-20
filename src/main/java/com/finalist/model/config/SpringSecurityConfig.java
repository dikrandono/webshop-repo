package com.finalist.model.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE))
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

		
	  public SpringSecurityConfig() {
	  
	  }
	

	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("user").password("123").roles("USER");
	    }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
				   /* http.authorizeRequests()
			                .antMatchers("/login.jsp").permitAll()
			                .antMatchers("/**").hasRole("USER")
			                .anyRequest().authenticated()
			                .and()
			                .formLogin().loginPage("/login.jsp").permitAll()
			                .usernameParameter("user").passwordParameter("pass")
			                .and().csrf().disable(); */
		        
				    http.authorizeRequests()
		                .antMatchers("/login.jsp").anonymous()
		                .anyRequest().authenticated()
		                .and().formLogin()
		                .loginPage("/login.jsp");
	  }

	

}
