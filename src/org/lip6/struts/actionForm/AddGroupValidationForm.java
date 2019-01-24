package org.lip6.struts.actionForm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.SessionFactory;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;

public class AddGroupValidationForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String groupName=null;
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//this.id=0;
		this.groupName=null;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		System.out.println("ADD GROUP VALIDATION");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService serviceContact = (service.ContactService) context.getBean("serviceContact");
        @SuppressWarnings("unused")
		List<Contact> listContacts = new ArrayList<Contact>();
       
        listContacts = (List<Contact>) serviceContact.getListContact();

        if( getGroupName()== null || getGroupName().length() < 1 ) {
        	errors.add("firstName",new ActionMessage("creation.fn.error.required"));
        }
        return errors;
	}
}