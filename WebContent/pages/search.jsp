<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<html>
<head>
	<link rel="stylesheet" type="text/css"
	href="css/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />
	

<title><bean:message key="main.search" /></title>
</head>
<body>
<div class="search">
	<h2> <bean:message key="main.search.info" /></h2>
	<html:form action="/Search">
		<html:errors />
				<tr>
					<td><html:text property="word" maxlength="50" /></td>
					<td><html:submit>
							<bean:message key="form.validation" />
						</html:submit></td>
					<td><html:reset>
							<bean:message key="form.reset" />
						</html:reset></td>
				</tr>
	</html:form>
	</div>

		<h4>
			<a href="Main.do"><bean:message key="main.redirection" /></a>
		</h4>

	
</body>
</html>