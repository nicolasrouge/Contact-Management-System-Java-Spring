package org.lip6.struts.domain;

import java.util.HashSet;
import java.util.Set;


public class ContactGroup {
	
	private long id_group;
	private String groupName;
	private Set<Contact> contacts = new HashSet<Contact>();
	private int version;
	
	public ContactGroup() {
		super();
	}
	public ContactGroup(long id_group, String groupName) {
		super();
		this.id_group = id_group;
		this.groupName = groupName;
	}
	
	public long getId_group() {
		return id_group;
	}
	public void setId_group(long id_group) {
		this.id_group = id_group;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public void setContact(Contact contact) {
		contacts.add(contact);
	}	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
}
