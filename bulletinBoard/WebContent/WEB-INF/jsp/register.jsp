<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
</head>
<body>
<form action="/bulletinBoard/RegisterServlet" method="post">
<ul>
 <li>ユーザーID：<input type="text" name="id"></li>
 <li>パスワード：<input type="password" name="pass"></li>
 <li>メールアドレス：<input type="text" name="mail"></li>
 <li>氏名：<input type="text" name="name"></li>
 <li>年齢：<input type="text" name="age"></li>
<li><input type="submit" value="登録"></li>
</ul>
</form>
</body>
</html>