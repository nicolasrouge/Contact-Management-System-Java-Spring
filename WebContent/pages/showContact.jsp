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

   <table>

        <tr>

          <td align="center" colspan="2">
        <font size="4">Détail du contact</font>
     </tr>
        <tr>
          <td align="right">
            <bean:message key="showlist.id" />
          </td>
          <td align="left">
          <td>ID : <bean:write name="infoContact" property="id"/></td>
          <td>Rue : <bean:write name="infoContact" property="street"/></td>
          <td>Rue : <bean:write name="infoContact" property="firstName"/></td>
          <td>Rue : <bean:write name="infoContact" property="lastName"/></td>
          <td>Rue : <bean:write name="infoContact" property="email"/></td>
          <td>Rue : <bean:write name="infoContact" property="phoneNumber"/></td>
          
        </tr>
		<tr>

  </table>
   
   </body>
   
   </html:html>