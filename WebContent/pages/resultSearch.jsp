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
	href="css\bootstrap-4.0.0-beta.2-dist\css\bootstrap.min.css" />
	
   	<title><bean:message key="add.contact"/></title>
   
   	</head>
	
   	<body bgcolor="white">
  	<h1>Mes contacts</h1>
  	<h4><a href="ContactCreation.do"><bean:message key="main.addcontact.link"/></a>
  	<a href="RecherchePage.do"><bean:message key="main.recherhce.link"/></a></h4>
	
	<table class="table table-hover" >
	<tr>
		<td>Id</td>
		<td>Prénom</td>
		<td>Nom</td>
		<td>Email</td>
	</tr>
	
	<logic:iterate name="listContacts" id="listContactId">

	
	<tr>
		<td><bean:write name="listContactId" property="id"/></td>
		<td><bean:write name="listContactId" property="lastname"/></td>
		<td><bean:write name="listContactId" property="firstname"/></td>
		<td><bean:write name="listContactId" property="email"/></td>
		
		<td><html:link action="UpdatePage.do" paramId="id" paramName="listContactId" paramProperty="id">
		<bean:message key="contact.update" />
		</html:link></td>
		
		<td><html:link action="RemoveContact.do" paramId="id" paramName="listContactId" paramProperty="id">
		<bean:message key="contact.remove" />
		</html:link></td>
	</tr>
	</logic:iterate>
	</table>
	<a href="Main.do"><bean:message key="main.redirection" /></a>
   </body>
   </html:html>