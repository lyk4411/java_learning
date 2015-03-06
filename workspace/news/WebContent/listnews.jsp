<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.*" %>
<%@ page import="com.domain.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border='1'>
		<tr>
			<th>Title</th>
			<th>Content</th>
			<th>CreateTime</th>
		</tr>
		<%
		//Class.forName("com.mysql.jdbc.Driver");
		//String url =  "jdbc:mysql://localhost:3306/newsdb";
		//String user = "root";
		//String password = "123456";
		
		ConnectionPool cp = (ConnectionPool)application.getAttribute("cp");
		Connection con = cp.getConnection();
		
		//Statement sta = con.createStatement();
		//ResultSet rs = sta.executeQuery("select * from news");
		
		List<News> newses = new NewsDAO(con).findAll();
		Iterator<News> it = newses.iterator();
		
		while(it.hasNext()) {
			News n = it.next();
		%>
		<tr>
			<td><%= n.getTitle() %></td>
			<td><%= n.getContent() %></td>
			<td><%= n.getCreateTime() %></td>
		</tr>
		<%
		}
		cp.releaseConnection();
		%>
	</table>

</body>
</html>