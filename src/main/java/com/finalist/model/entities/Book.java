package com.finalist.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity  
@Table(name="BOOK") 
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="titel", nullable = false)
	private String titel;
	
	@Column(name="auther")
	private String auther;
	
	@ManyToOne()
	@JoinColumn(foreignKey = @ForeignKey(name = "BOOK_TO_PERSON"))	
	private Person loanedTo;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="BOOK_LANG", foreignKey = 
			@ForeignKey(name = "BOOK_LANG_TO_LANG"),
			inverseForeignKey = @ForeignKey(name = "BOOK_LANG_TO_BOOK"))
	List<Language> languages;

	
	protected Book() {
	}
	
	public Book(String titel, String auther) {
		this.setTitel(titel);
		this.setAuther(auther);
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Person getLoanedTo() {
		return loanedTo;
	}

	public void setLoanedTo(Person loanedTo) {
		this.loanedTo = loanedTo;
	}

	public String getTitel() {
		return titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public String getAuther() {
		return auther;
	}


	public void setAuther(String auther) {
		this.auther = auther;
	}


	public List<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	

}
