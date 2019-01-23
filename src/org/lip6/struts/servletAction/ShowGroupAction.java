package org.lip6.struts.servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.UpdateContactValidationForm;
import org.lip6.struts.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;

public class ShowGroupAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UpdateContactValidationForm lForm = new UpdateContactValidationForm();
		
		final long id = Long.parseLong(request.getParameter("id"));
		
        ContactService lContactService = new ContactService();
	    
        
        List<Contact> listGroupContacts = new ArrayList<Contact>();
        List<Contact> listContactsOutOfGroup = new ArrayList<Contact>();
        
    	listGroupContacts = lContactService.getGroupContacts(id);
    	listContactsOutOfGroup = lContactService.getContactsOutOfGroup(id);
    	
    	request.setAttribute("listGroupContacts", listGroupContacts);
    	request.setAttribute("listContactsOutOfGroup", listContactsOutOfGroup);
    	if(listGroupContacts.isEmpty()) {
            return mapping.findForward("displaylist");
        }
    	else
    		return mapping.findForward("displaylist");
    	}
}