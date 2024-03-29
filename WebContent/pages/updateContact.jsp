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
        <font size="4">Please Enter the Following Details</font>
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
            <bean:message key="showlist.email" />
          </td>
          <td align="left">
            <html:text property="email" size="30" maxlength="30"/>
            <html:errors property="email" />
          </td>
        </tr>
    <tr>
          <td align="right">
            <html:submit><bean:message key="button.save" /></html:submit>
          </td>
          
          <td align="right"><html:reset>
						<bean:message key="form.reset" />
		</html:reset></td>
    </tr>
  </table>
   </html:form>
   
   </body>
   
   </html:html>