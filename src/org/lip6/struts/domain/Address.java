package org.lip6.struts.domain;

public class Address {
	private long address_ID;
	private String street;
	private String city;
	private String zip;
	private String country;
	private int version;
	
	public Address() {
		super();
	}
	public Address(long address_ID, String street, String city, String zip, String country) {
		super();
		this.address_ID = address_ID;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	public long getAddress_ID() {
		return address_ID;
	}
	public void setAddress_ID(long address_ID) {
		this.address_ID = address_ID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
