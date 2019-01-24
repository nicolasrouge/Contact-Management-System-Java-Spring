<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

   <html:html>

   <head>
   	
   	
	<link rel="stylesheet" type="text/css"
	href="css/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />
	
   <title><bean:message key="add.contact"/></title>


   </head>
   
   <html:form action="AddContact">

   <table>

        <tr>

          <td align="center" colspan="2">
        <h1><bean:message key="add.title"/></h1>
     	</tr>
		<tr>
          <td align="right">
            <bean:message key="showlist.fname" />
          </td>
          <td align="left">
            <html:text property="firstname" size="30" maxlength="30"/>
            <html:errors property="firstname" />

          </td>
        </tr>
        <tr>
          <td align="right">
            <bean:message key="showlist.lname" />
          </td>
          <td align="left">
            <html:text property="lastname" size="30" maxlength="30"/>
            <html:errors property="lastname" />
            
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
            <html:text property="phonenumber" size="30" maxlength="30"/>
            <html:errors property="phonenumber" />
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
  		<h4>
			<a href="Main.do"><bean:message key="main.redirection" /></a>
		</h4>
   </html:form>
   </body>
   </html:html>