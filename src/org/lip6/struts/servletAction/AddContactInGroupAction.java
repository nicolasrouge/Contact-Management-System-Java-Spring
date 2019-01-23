package org.lip6.struts.servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddContactInGroupValidationForm;
import org.lip6.struts.domain.Contact;

import service.ContactService;


public class AddContactInGroupAction extends Action {
    
    public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest request, final HttpServletResponse pResponse) throws Exception {
    	final AddContactInGroupValidationForm lForm=(AddContactInGroupValidationForm)pForm;
       
    	final long idGroup = Long.parseLong(request.getParameter("id"));
    	System.out.println("ACTION ADD  grouppppppppppp--->" + idGroup);
    	final long idContact = Long.parseLong(request.getParameter("idContact"));
    	System.out.println("ACTION ADD  connntacttttt--->" + idContact);
        //final long idContact = lForm.getId();
        //final long idGroup = lForm.getIdGroup();
        
        ContactService lContactService = new ContactService();
        
        lContactService.addContactToGroup(idContact, idGroup);
        //System.out.println("ACTION ADD --->" + nom + prenom);

        List<Contact> listGroupContacts = new ArrayList<Contact>();
        List<Contact> listContactsOutOfGroup = new ArrayList<Contact>();
        
    	listGroupContacts = lContactService.getGroupContacts(idGroup);
    	listContactsOutOfGroup = lContactService.getContactsOutOfGroup(idGroup);
    	
    	request.setAttribute("listGroupContacts", listGroupContacts);
    	request.setAttribute("listContactsOutOfGroup", listContactsOutOfGroup);
    	if(listGroupContacts.isEmpty()) {
            return mapping.findForward("displaylist");
        }
    	else
    		return mapping.findForward("displaylist");
    	}
}