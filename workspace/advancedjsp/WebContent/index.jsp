<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<%@ page  import="com.domain.User"%>

<jsp:forward page="hello.jsp">
	<jsp:param value="18" name="age"/>
</jsp:forward>
<jsp:useBean id="user" class="com.domain.User" scope="session"></jsp:useBean>
<jsp:setProperty property="username" name="user" param="username"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<table>
	<tr>
		<td colspan="2"><jsp:include page="head.jsp"></jsp:include> 
	</tr>
	<tr>
		<td colspan="2"><jsp:include page="menu.jsp"></jsp:include> 
	</tr>
</table>


<body>
<%
out.println(user.getUsername());
	//User user = (User) session.getAttribute("user");
	/*if(user == null){
		user=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		out.println(user.getUsername());
		
		session.setAttribute("user", user);
	}*/
	out.println(user.getUsername());
	//user.setUsername(request.getParameter("username"));
	out.println(Math.random() + "<br />");

	int i = 3;
	//int res = i/0;

	Integer num = (Integer)session.getAttribute("number");
	if(num == null){
		num = (int)(Math.random()*100) + 1;
		session.setAttribute("number", null);
	}
	out.print(num);

	out.println(user.getUsername());
	
%>
</body>
</html>