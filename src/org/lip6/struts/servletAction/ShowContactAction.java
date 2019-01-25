package org.lip6.struts.servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.UpdateContactValidationForm;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.PhoneNumber;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;

public class ShowContactAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UpdateContactValidationForm lForm = new UpdateContactValidationForm();
		
		final int id = Integer.parseInt(request.getParameter("id"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");
	     
    	Contact contact = lContactService.getContact(id);
		lForm.setId(id);
		lForm.setFirstname(contact.getFirstname());
		lForm.setLastname(contact.getLastname());
		lForm.setEmail(contact.getEmail());
		List<PhoneNumber> phones;
		phones = lContactService.getPhones(id);
		lForm.setPhoneNumber(phones.get(0).getPhoneNumber());
		lForm.setStreet(contact.getAddress().getStreet());
		lForm.setCity(contact.getAddress().getCity());
		lForm.setZip(contact.getAddress().getZip());
		lForm.setCountry(contact.getAddress().getCountry());
		
		request.getServletContext().setAttribute("infoContact", lForm);
		
    	if(id > 0) {
            // if no exception is raised,  forward "success"
            return mapping.findForward("success");
        }
        else {
            // If any exception, return the "error" forward
            return mapping.findForward("error");
        }
    }
}