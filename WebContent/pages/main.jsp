<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<html:html>
    <head>
    	<link rel="stylesheet" type="text/css"
	href="css/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />
	
	    	<link rel="stylesheet" type="text/css"
	href="css/style.css" />
    
        <title><bean:message key="main.page.title"/></title>
        
    </head> 

    <body>
    <div class="main">
        <h1><bean:message key="main.page.menu"/></h1>
  		<h4><a href="ListPage.do"><bean:message key="main.list.link"/></a></h4><br>
  		</div>
    </body>
   </html:html>