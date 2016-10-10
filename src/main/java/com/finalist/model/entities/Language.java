package com.finalist.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 
@Entity  
@Table(name="LANGUAGE") 
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id", unique = true, nullable = false)
	private int id;
	
	@Column(name="titel", nullable = false)
	private String titel;
	
	public Language() {
		// TODO Auto-generated constructor stub
	}
	
	public Language(String titel) {
		this.setTitel(titel);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

}
