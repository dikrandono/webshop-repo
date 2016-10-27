package com.finalist.model.config.oauth2config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import com.finalist.model.config.SpringConfig;

@Configuration
@EnableResourceServer
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE))
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "my_rest_api";
	
	
	public ResourceServerConfiguration() {
	}
	
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(true);
    }
    
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().anonymous().disable()
        .requestMatchers().antMatchers("/user/**")
        .and().authorizeRequests()
        .antMatchers("/user/**").access("hasRole('USER')")
        .antMatchers("/oauth/token").permitAll()
        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
    

}
