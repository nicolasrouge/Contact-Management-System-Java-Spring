package org.lip6.struts.domain;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	
	private long id_contact;
	private String lastname;
	private String firstname;
	private String email;
	private Address address;
	private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
	private Set<ContactGroup> groups = new HashSet<ContactGroup>();
	private int version;
	
	public Contact() {
	}
	
	public Contact(long id_contact, String lastname, String firstname, String mail, Address address) {
		super();
		this.id_contact = id_contact;
		this.lastname= lastname;
		this.firstname = firstname;
		this.email = mail;
		this.address = address;
	}
	
	public Contact(String lastname, String firstname, String mail, Address address) {
		super();
		this.lastname= lastname;
		this.firstname = firstname;
		this.email = mail;
		this.address = address;
	}
	
	public Contact(Contact contact) {
		super();
		this.id_contact = contact.id_contact;
		this.lastname= contact.lastname;
		this.firstname = contact.firstname;
		this.email = contact.email;
		this.address = contact.address;
		this.phones = contact.phones;
		this.groups = contact.groups;
	}

	public long getId_contact() {
		return id_contact;
	}

	public void setId_contact(long id_contact) {
		this.id_contact = id_contact;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname= lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	public Set<ContactGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
}