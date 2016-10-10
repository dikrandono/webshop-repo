package com.finalist.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
 
@Entity  
@Table(name="USER")  
@Inheritance(strategy=InheritanceType.JOINED)  
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="password")
	private String password;
	
		
	protected User() {
		// only for JPA
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
