<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

please input news content<br />
<form name="news_form" action="createnews.do" method="post">
news title:<input type="text" name="title"> <br />
news content:<textarea rows="6" cols="24" name="content"></textarea><br />
<input type="submit" value="issue news" />
</form>
</body>
</html>