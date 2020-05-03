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
<form action="/bulletinBoard/RegisterServlet" method="post">
<ul>
 <li>ユーザーID：<input type="text" value="<c:out value="${account.id}"/>" name="id"></li>
 <li>パスワード：<input type="password" value="<c:out value="${account.pass}"/>" name="pass"></li>
 <li>メールアドレス：<input type="text" value="<c:out value="${account.mail}"/>" name="mail"></li>
 <li>氏名：<input type="text" value="<c:out value="${account.name}"/>" name="name"></li>
 <li>年齢：<input type="text" value="<c:out value="${account.age}"/>" name="age"></li>
<li><input type="submit" value="登録"></li>
</ul>
</form>
</body>
</html>