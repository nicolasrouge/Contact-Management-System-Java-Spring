package org.lip6.struts.domain;

import java.util.HashSet;
import java.util.Set;


public class ContactGroup {
	
	private long group_ID;
	private String groupName;
	private Set<Contact> contacts = new HashSet<Contact>();
	private int version;
	
	public ContactGroup() {
		super();
	}
	public ContactGroup(long group_ID, String groupName) {
		super();
		this.group_ID = group_ID;
		this.groupName = groupName;
	}
	
	public long getGroup_ID() {
		return group_ID;
	}
	public void setGroup_ID(long group_ID) {
		this.group_ID = group_ID;
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
