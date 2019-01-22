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
	
   	<title><bean:message key="group.list"/></title>
   
   	</head>
	
   	<body bgcolor="white">
  	<h1 align="center"><bean:message key="group.list"/></h1>
  	<h4><a href="createGroup.do" ><bean:message key="main.addgroup.link"/></a></h4>
	<table class="table table-striped" >
	<tr>
		<td><bean:message key="showlist.id"/></td>
		<td><bean:message key="group.name"/></td>
		<td align="center" colspan="2">Actions</td>
	</tr>

	<logic:iterate name="listGroups" id="listGroupId">
	<tr>
		<td><bean:write name="listGroupId" property="group_ID"/></td>
		<td><bean:write name="listGroupId" property="groupName"/></td>
		
		<td><html:link action="ShowGroup.do" paramId="id" paramName="listGroupId" paramProperty="group_ID">
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