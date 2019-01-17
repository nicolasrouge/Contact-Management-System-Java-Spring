package org.lip6.struts.domain;

public class PhoneNumber {
	
	private long phone_ID;
	private String phoneNumber;
	private Contact contact;
	private int version;
	
	public PhoneNumber() {
		super();
	}
	
	public PhoneNumber(long phone_ID, String phoneNumber, Contact contact) {
		super();
		this.phone_ID = phone_ID;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	
	public long getPhone_ID() {
		return phone_ID;
	}
	public void setPhone_ID(long phone_ID) {
		this.phone_ID = phone_ID;
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
