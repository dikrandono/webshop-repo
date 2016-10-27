package com.finalist.model.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

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
		 
		//auth.inMemoryAuthentication()
		// .withUser("user").password("123").roles("USER" , "ADMIN");
		
		 auth.userDetailsService(myUserClientDetailsService);
		  		 

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests()
	        .antMatchers("/login*").permitAll()
	        .antMatchers("/oauth/token").permitAll()
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/**").access("hasRole('USER')")
			.anyRequest().authenticated()
		
			.and().formLogin().loginPage("/login").permitAll()
			//.usernameParameter("username")
			//.passwordParameter("password")
			//.successForwardUrl("/index")
			//.failureUrl("/loginerror")
			//.loginProcessingUrl("/myLoginform")
			.and().csrf().disable();
		
	}
	
	 
	@Override
    @Bean(name = "myAuthenticationManagerBean")
    public AuthenticationManager authenticationManagerBean() throws Exception {
		
        return super.authenticationManagerBean();
    } 
	
	 

}
