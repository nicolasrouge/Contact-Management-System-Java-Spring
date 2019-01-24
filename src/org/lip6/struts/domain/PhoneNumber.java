package org.lip6.struts.domain;

public class PhoneNumber {
	
	private long id_phone;
	private String phoneNumber;
	private Contact contact;
	
	public PhoneNumber() {
		super();
	}
	
	public PhoneNumber(long id_phone, String phoneNumber, Contact contact) {
		super();
		this.id_phone = id_phone;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	
	public PhoneNumber(String phoneNumber, Contact contact) {
		super();
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	
	public long getId_phone() {
		return id_phone;
	}
	public void setId_phone(long id_phone) {
		this.id_phone = id_phone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
