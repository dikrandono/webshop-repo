package com.finalist.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.stereotype.Service;

import com.finalist.model.entities.Person;

@Service("loginUserDetailsService")
public class LoginUserDetailsService implements UserDetailsService,ClientDetailsService {

	@Autowired
	PersonService personService;
	
	 private  ClientDetailsService clients; 
	 	  
	 private  ClientDetailsUserDetailsService clientDetailsWrapper; 
	
 
	public LoginUserDetailsService( ) throws Exception { 
			  super(); 
			  clients = new InMemoryClientDetailsServiceBuilder() 
					    
					     .withClient("my-client").
					     authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit") 
					     .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT","ROLE_USER") 
					     .scopes("read", "write", "trust").secret("secret")
					     .accessTokenValiditySeconds(120) //Access token is only valid for 2 minutes.
				         .refreshTokenValiditySeconds(600)
					     .resourceIds("MyResourceId") 
					     .and().build(); 
				 
			  clientDetailsWrapper = new ClientDetailsUserDetailsService(clients); 
			 } 
			 

	@Override 
	 public ClientDetails loadClientByClientId(String clientId)throws ClientRegistrationException { 
		
		System.out.println("loadClientByClientId loadClientByClientId  =====  " + clientId);
		
		return clients.loadClientByClientId(clientId); 
	 } 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername loadUserByUsername  =====  " + username);
		Person person = personService.findPersonByUsername(username);
		
		if (person == null || person.getId() == 0) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}

		return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), true,
				true, true, true, getGrantedPermissions());

	}

	private List<GrantedAuthority> getGrantedPermissions() {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return authorities;
	}

}
