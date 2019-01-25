<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

   <html:html>

   <head>
   	
   	
	<link rel="stylesheet" type="text/css"
	href="css/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />
	
   <title><bean:message key="add.group"/></title>


   </head>
   
   <html:form action="AddGroup">

   <table>
   		<tr>
   			<td align="center" colspan="2">
        	<h1><bean:message key="add.group.title"/></h1>
     	</tr>
		
		<tr>
          <td align="right">
            <bean:message key="showlist.groupName"/>
          </td>
          <td align="left">
            <html:text property="groupName" size="30" maxlength="30"/>
            <html:errors property="groupName"/>
          </td>
        </tr>
    
    	<tr>
          <td align="right">
            <html:submit><bean:message key="button.save"/></html:submit>
          </td>
    	</tr>
  
  </table>
  		<h4>
			<a href="Main.do"><bean:message key="main.redirection"/></a>
		</h4>
   </html:form>
   </body>
   </html:html>