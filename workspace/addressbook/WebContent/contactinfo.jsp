<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<dir style="color:red">
	<html:errors />
</dir>
please input information of contacts:<br />
<bean:message key="contactform.title" />

<form name="contact_form" method="post" action="createcontact.do"></form>

<bean:message key="contactform.name" />contact name: <input type="text" name="name" /><br />
<bean:message key="contactform.phone" />contact phone:<input type="text" name="phone" /><br />
<bean:message key="contactform.address" />contact address:<input type="text" name="address"><br />
<input type="submit" value='<bean:message key="contactform.submitlabel" />' />

</body>
</html>