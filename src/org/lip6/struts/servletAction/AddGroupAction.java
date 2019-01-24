package org.lip6.struts.servletAction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.actionForm.AddGroupValidationForm;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.ContactGroup;
import org.lip6.struts.domain.DAOContact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;


public class AddGroupAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) throws NamingException, SQLException {
    	final AddGroupValidationForm lForm=(AddGroupValidationForm)pForm;
        
    	final String nomGroupe = lForm.getGroupName();
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");
       
        lContactService.addGroup(nomGroupe);
        List<ContactGroup> listGroups = new ArrayList<ContactGroup>();
        listGroups = lContactService.getListGroup();
    	pRequest.setAttribute("listGroups", listGroups);
    	return pMapping.findForward("displaygrouplist");
    }
   
}