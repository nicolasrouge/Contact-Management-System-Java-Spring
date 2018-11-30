package org.lip6.struts.domain;

public class ContactGroup1 {
	
	private long groupId;
	private String groupName;
	
	public ContactGroup1(long groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
