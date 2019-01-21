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
	
   	<title><bean:message key="add.contact"/></title>
   
   	</head>
	
   	<body bgcolor="white">
  	<h1 align="center"><bean:message key="showlist.title"/></h1>
  	<h4 ><a href="ContactCreation.do" ><bean:message key="main.addcontact.link"/></a>
  	<a href="createGroup.do" ><bean:message key="main.addgroup.link"/></a>
  	<a href="RecherchePage.do"><bean:message key="main.recherhce.link"/></a>
  	<a href="GroupList.do"><bean:message key="main.list.group.link"/></a></h4><br>
	<table class="table table-striped" >
	<tr>
		<td><bean:message key="showlist.id"/></td>
		<td><bean:message key="showlist.fname"/></td>
		<td><bean:message key="showlist.lname"/></td>
		<td><bean:message key="showlist.email"/></td>
		<td align="center" colspan="2">Actions</td>
	</tr>

	<logic:iterate name="listContacts" id="listContactId">
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
			<h4>
			<a href="Main.do"><bean:message key="main.redirection" /></a>
		</h4>
   </body>
   </html:html>