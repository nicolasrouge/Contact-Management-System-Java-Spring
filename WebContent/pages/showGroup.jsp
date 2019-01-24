<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import ="org.lip6.struts.domain.Contact" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>

  
   <html:html>
   
   	<head>
   	
	<link rel="stylesheet" type="text/css"
	href="css\bootstrap-4.0.0-beta.2-dist\css\bootstrap.css" />
	
   	<title>Mon groupe</title>
   
   	</head>
	
   	<body bgcolor="white">
  	<h1 align="center">Gérer le groupe <%out.println(request.getParameter("id"));%></h1>
  	<h4 >
  	<a href="createGroup.do" ><bean:message key="main.addgroup.link"/></a></h4>
  	<br>
  	
  	<h2>Contacts du groupe</h2>
  	
	<table class="table table-striped" >
	<tr>
		<td><bean:message key="showlist.id"/></td>
		<td><bean:message key="showlist.fname"/></td>
		<td><bean:message key="showlist.lname"/></td>
		<td><bean:message key="showlist.email"/></td>
		<td align="center" colspan="2">Actions</td>
	</tr>

	<logic:iterate name="listGroupContacts" id="listContactId">
	<tr>
		<td><bean:write name="listContactId" property="contact_ID"/></td>
		<td><bean:write name="listContactId" property="prenom"/></td>
		<td><bean:write name="listContactId" property="nom"/></td>
		<td><bean:write name="listContactId" property="mail"/></td>
		
		<td><html:link action="UpdatePage.do" paramId="id" paramName="listContactId" paramProperty="contact_ID">
		<bean:message key="contact.update" />
		</html:link></td>
		
		<td><html:link action="RemoveContact.do" paramId="id" paramName="listContactId" paramProperty="contact_ID">
		<bean:message key="contact.remove" />
		</html:link></td>
		
		<td><html:link action="ShowContact.do" paramId="id" paramName="listContactId" paramProperty="contact_ID">
		<bean:message key="contact.show" />
		</html:link></td>
		
	</tr>
	</logic:iterate>
	
		</table>
		
		<h2>Tous les contacts</h2>
		<table class="table table-striped" >
	<tr>
		<td><bean:message key="showlist.id"/></td>
		<td><bean:message key="showlist.fname"/></td>
		<td><bean:message key="showlist.lname"/></td>
		<td><bean:message key="showlist.email"/></td>
		<td align="center" colspan="2">Actions</td>
	</tr>
	<logic:iterate name="listContactsOutOfGroup" id="listContactId">
	<tr>
		<td><bean:write name="listContactId" property="contact_ID"/></td>
		<td><bean:write name="listContactId" property="prenom"/></td>
		<td><bean:write name="listContactId" property="nom"/></td>
		<td><bean:write name="listContactId" property="mail"/></td>
		
		<td><a href="AddContactInGroup.do?id=<%out.println(request.getParameter("id"));%>&idContact=<bean:write name="listContactId" property="contact_ID"/>">
		<bean:message key="contact.add.in.group"/></a></td>
		
	</logic:iterate>
	
	</table>
	

			<h4>
			<html:link action="GroupList.do" ><bean:message key="liste.contact.redirection" /></html:link>
		</h4>
   </body>
</html:html>