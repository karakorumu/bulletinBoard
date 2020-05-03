<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bulletinBoard/LoginServlet" method="post">
<ul>
 <li>ユーザーID：<input type="text" value="<c:out value="${login.id}"/>" name="id"></li>
 <li>パスワード：<input type="password" value="<c:out value="${login.pass}"/>" name="pass"></li>
<li><input type="submit" value="ログイン"></li>
</ul>
</form>
</body>
</html>