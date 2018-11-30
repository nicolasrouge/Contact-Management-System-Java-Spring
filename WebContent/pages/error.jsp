<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html:html>
    <head>
    	<link rel="stylesheet" type="text/css"
	href="css/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />
    
        <title><bean:message key="title.error"/></title>
    </head>
    <body>
        <html:errors/><br/> 
        <p></p>
        <html:errors/>
        <h4><a href="ContactCreation.do"><bean:message key="main.addcontact.link"/></a>
        <a href="Main.do"><bean:message key="main.redirection" /></a></h4>
    </body>
</html:html>