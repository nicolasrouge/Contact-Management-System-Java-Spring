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
   <html:form action="UpdateContact">

   <table>
		<tr>
        	<td align="center" colspan="2">
        	<font size="4"><bean:message key="following.enter" /></font>
     	</tr>
     	
        <tr>
          <td align="right">
            <bean:message key="showlist.id" />
          </td>
          <td align="left">
            <html:text property="id" size="30" maxlength="30" readonly="true"/>
          </td>
        </tr>
        
		<tr>

          <td align="center" colspan="2">
        <h1><bean:message key="update.title"/></h1>
     	</tr>
		<tr>
          <td align="right">
            <bean:message key="showlist.fname" />
          </td>
          <td align="left">
            <html:text property="firstName" size="30" maxlength="30"/>
            <html:errors property="firstName" />

          </td>
        </tr>
        <tr>
          <td align="right">
            <bean:message key="showlist.lname" />
          </td>
          <td align="left">
            <html:text property="lastName" size="30" maxlength="30"/>
            <html:errors property="lastName" />
            
          </td>
        </tr>

        <tr>
          <td align="right">
           <bean:message key="label.email" />
          </td>
          <td align="left">
            <html:text property="email" size="30" maxlength="30"/>
            <html:errors property="email" />
          </td>
        </tr>
        
         <tr>
          <td align="right">
           <bean:message key="showlist.tel" />
          </td>
          <td align="left">
            <html:text property="phoneNumber" size="30" maxlength="30"/>
            <html:errors property="phoneNumber" />
          </td>
        </tr>
        
        <tr>
          <td align="right">
           <bean:message key="showlist.street" />
          </td>
          <td align="left">
            <html:text property="street" size="30" maxlength="30"/>
            <html:errors property="street" />
          </td>
        </tr>
        
        <tr>
          <td align="right">
           <bean:message key="showlist.city" />
          </td>
          <td align="left">
            <html:text property="city" size="30" maxlength="30"/>
            <html:errors property="city" />
          </td>
        </tr>
        
        <tr>
          <td align="right">
           <bean:message key="showlist.zip" />
          </td>
          <td align="left">
            <html:text property="zip" size="30" maxlength="30"/>
            <html:errors property="zip" />
          </td>
        </tr>
        
        <tr>
          <td align="right">
           <bean:message key="showlist.country" />
          </td>
          <td align="left">
            <html:text property="country" size="30" maxlength="30"/>
            <html:errors property="country" />
          </td>
        </tr>
    <tr>
          <td align="right">
            <html:submit><bean:message key="button.save" /></html:submit>
          </td>
          
    </tr>
  </table>
   </html:form>
   
   </body>
   
</html:html>