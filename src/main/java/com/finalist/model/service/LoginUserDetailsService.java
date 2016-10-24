package com.finalist.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.finalist.model.entities.Person;

@Service("loginUserDetailsService")
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	PersonService personService;

	public LoginUserDetailsService() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

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
