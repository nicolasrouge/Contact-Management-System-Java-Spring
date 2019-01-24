package org.lip6.struts.servletAction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;

public class ContactListAction extends Action {
	
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws NamingException, SQLException {
			
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");

        lContactService.generate();
        
        List<Contact> listContacts = new ArrayList<Contact>();
        
        listContacts = (List<Contact>) lContactService.getListContact();
        
    	request.setAttribute("listContacts", listContacts);
    	if(listContacts.isEmpty()) {
            return mapping.findForward("displaylist");
        }
    	else
    		return mapping.findForward("displaylist");
    	}
}