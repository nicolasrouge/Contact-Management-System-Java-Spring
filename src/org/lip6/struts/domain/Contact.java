package org.lip6.struts.domain;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	
	private long contact_ID;
	private String nom;
	private String prenom;
	private String mail;
	private Address address;
	private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
	private Set<ContactGroup> groups = new HashSet<ContactGroup>();
	private int version;
	
	public Contact() {
	}
	
	public Contact(long contact_ID, String nom, String prenom, String mail, Address address) {
		super();
		this.contact_ID = contact_ID;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.address = address;
	}
	
	public Contact(String nom, String prenom, String mail, Address address) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.address = address;
	}
	
	public Contact(Contact contact) {
		super();
		this.contact_ID = contact.contact_ID;
		this.nom = contact.nom;
		this.prenom = contact.prenom;
		this.mail = contact.mail;
		this.address = contact.address;
		this.phones = contact.phones;
		this.groups = contact.groups;
	}

	public long getContact_ID() {
		return contact_ID;
	}

	public void setContact_ID(long contact_ID) {
		this.contact_ID = contact_ID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
	
	public int getVersion(int version) {
		return version;
	}
}