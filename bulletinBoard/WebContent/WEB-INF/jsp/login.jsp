<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action="/bulletinBoard/LoginServlet" method="post">
<ul>
 <li>ユーザーID：<input type="text" name="id"></li>
 <li>パスワード：<input type="password" name="pass"></li>
</ul>
<input type="submit" value="ログイン">
</form>
</body>
</html>