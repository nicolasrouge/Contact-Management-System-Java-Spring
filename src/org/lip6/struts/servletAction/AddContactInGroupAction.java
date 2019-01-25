package org.lip6.struts.servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;


public class AddContactInGroupAction extends Action {
    
    public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest request, final HttpServletResponse pResponse) throws Exception {
    	//final AddContactInGroupValidationForm lForm=(AddContactInGroupValidationForm)pForm;
       
    	final long idGroup = Long.parseLong(request.getParameter("id"));
    	final long idContact = Long.parseLong(request.getParameter("idContact"));
        
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");
       
        lContactService.addContactToGroup(idContact, idGroup);

        List<Contact> listGroupContacts = new ArrayList<Contact>();
        List<Contact> listContactsOutOfGroup = new ArrayList<Contact>();
        
    	listGroupContacts = lContactService.getGroupContacts(idGroup);
    	listContactsOutOfGroup = lContactService.getContactsOutOfGroup(idGroup);
    	
    	request.setAttribute("listGroupContacts", listGroupContacts);
    	request.setAttribute("listContactsOutOfGroup", listContactsOutOfGroup);
            
    	return mapping.findForward("displaylist");
        }
}