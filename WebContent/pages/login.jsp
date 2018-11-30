<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<html:html>

   <head>
   
   <link rel="stylesheet" type="text/css"
   href="css/bootstrap-4.0.0-beta.2-dist/css/bootstrap.custom.login.css" />
   
      <link rel="stylesheet" type="text/css"
   href="css/style.css" />
   
   <title><bean:message key="main.login.link"/></title>   
   </head>
   <h1 align="center">Projet Gestion de contacts : Struts </h1>
   <h2 align="center"><bean:message key="main.login.link"/></h2>
    <html:form action="Login" >
    <div class="login">
       <html:errors/>
        User Name :<html:text name="LoginForm" property="userName" />
        Password  :<html:password name="LoginForm" property="password" />
        <html:submit value="Login" />
        </div>
    </html:form>
   </body>
   </html:html>