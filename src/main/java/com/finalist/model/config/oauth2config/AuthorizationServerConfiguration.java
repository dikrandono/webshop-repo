package com.finalist.model.config.oauth2config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.finalist.model.config.SpringConfig;
import com.finalist.model.service.LoginUserDetailsService;

@Configuration
@EnableAuthorizationServer
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE))
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{   
 
    @Autowired
    @Qualifier("myAuthenticationManagerBean")
    private AuthenticationManager authenticationManager;
    
    @Autowired
	@Qualifier("loginUserDetailsService")
    LoginUserDetailsService myUserClientDetailsService;
 
	
	public AuthorizationServerConfiguration() {
	}
	
	
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
     
		clients.withClientDetails(myUserClientDetailsService); 
    }
 
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	//endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler);
    	 
    	endpoints.authenticationManager(authenticationManager);
    }
 
}
