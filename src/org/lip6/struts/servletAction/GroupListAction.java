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
import org.lip6.struts.domain.ContactGroup;

import service.ContactService;

public class GroupListAction extends Action {
	
    public ActionForward execute(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws NamingException, SQLException {
    	
        ContactService lContactSerive = new ContactService();
        
        List<ContactGroup> listGroups = new ArrayList<ContactGroup>();
        
        listGroups = lContactSerive.getListGroup();
        
    	request.setAttribute("listGroups", listGroups);
    	
    	if(listGroups.isEmpty()) {
    		return mapping.findForward("displaygrouplist");
        }
    	else
    		return mapping.findForward("displaygrouplist");
    	}
    
}
