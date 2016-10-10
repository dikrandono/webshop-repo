package com.finalist.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity  
@Table(name="PERSON")
public class Person extends User {


	@Column(name="first_name", length = 100)
	private String firstname;
	
	@Column(name="last_name", length = 100)
	private String lastname;

	@Column(name="birthday")
	private Date birthday;
	
	@OneToMany(mappedBy = "loanedTo")  //, fetch = FetchType.LAZY
	List<Book> books ;
	

	public Person() {
		
	}
	
	
	public Person(String username,String password ,String firstname, String lastname) {
		super(username, password);
		 
		this.firstname = firstname;
		this.lastname = lastname;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}

	 
}
