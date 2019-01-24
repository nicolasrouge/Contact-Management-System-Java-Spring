<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

   <html:html>

   <head>
   
      	
	<link rel="stylesheet" type="text/css"
	href="css\bootstrap-4.0.0-beta.2-dist\css\bootstrap.min.css" />
	
   <title><bean:message key="update.contact"/></title>

   <html:base/>

   </head>

   <body bgcolor="white">
  	<h1 align="center"><bean:message key="look.title"/><br/></h1>

   <table>

        <tr>
          <td> <bean:message key="showlist.id" /> : <bean:write name="infoContact" property="id"/><br/></td> 
          </tr>
          <tr>
          <td> <bean:message key="showlist.fname" /> : <bean:write name="infoContact" property="firstName"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="showlist.lname" /> : <bean:write name="infoContact" property="lastName"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="label.email" /> : <bean:write name="infoContact" property="email"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="showlist.tel" /> : <bean:write name="infoContact" property="phoneNumber"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="showlist.street" /> : <bean:write name="infoContact" property="street"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="showlist.city" /> : <bean:write name="infoContact" property="city"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="showlist.zip" /> : <bean:write name="infoContact" property="zip"/><br/></td>
                    </tr>
          <tr>
          <td> <bean:message key="showlist.country" /> : <bean:write name="infoContact" property="country"/><br/></td>    
        </tr>

  </table>
  
  <h4>
		<html:link action="ListPage.do" ><bean:message key="liste.contact.redirection" /></html:link>
  </h4>
   
   </body>
   
   </html:html>