package org.lip6.struts.domain;

import java.util.Set;

public class Contact1 {
      private long id;   
      private String firstName;
      private String lastName;
      private String email;
  	private Set<ContactGroup1> books;
  	
	public Contact1(long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Contact1(long id, String firstName, String lastName, String email, Set<ContactGroup1> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.books = books;
	}

	public Contact1() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<ContactGroup1> getBooks() {
		return books;
	}

	public void setBooks(Set<ContactGroup1> books) {
		this.books = books;
	}
	
}
