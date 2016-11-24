package com.finalist.model.config;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.finalist.model.service.LoginUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE))
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("loginUserDetailsService")
	LoginUserDetailsService myUserClientDetailsService;
	
	
	public SpringSecurityConfig() {

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 
		//  auth.inMemoryAuthentication()
		// .withUser("user").password("123").roles("USER" , "ADMIN");
		
		 auth.userDetailsService(myUserClientDetailsService);
		  		 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            //.and().headers().frameOptions().disable()
            .and().authorizeRequests()
	        .antMatchers("/loginjsp").permitAll()
	        .antMatchers("/login-ang").permitAll()
	        .antMatchers("/oauth/token").permitAll()
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/**").access("hasRole('USER')")
			.anyRequest().authenticated()
			
			.and().formLogin().loginPage("/loginjsp").permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.successForwardUrl("/indexjsp")
			//.failureUrl("/loginerror")
			.loginProcessingUrl("/myLoginform")
			.and().csrf().disable();
		
	}
	
	 
	@Override
    @Bean(name = "myAuthenticationManagerBean")
    public AuthenticationManager authenticationManagerBean() throws Exception {
		
        return super.authenticationManagerBean();
    } 
	
	 

}
