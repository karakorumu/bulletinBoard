<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド</title>
</head>
<body>
<h1><c:out value="${tablename.getName()}"/></h1><br>
<a href="/bulletinBoard/CommentCreateServlet">ホームに戻る</a>
<br><br>
<form action="/bulletinBoard/CommentCreateServlet" method="post">
コメント:<input type="text" name="text">
<input type="submit" value="送信">
</form>
<br>
    <c:if test="${not empty errorMsg}">
    	<p>${errorMsg}</p>
    </c:if>
<br>
 	<c:forEach var="comment" items="${commentList}">
		${comment.getId()}:${comment.getText()}
  		<br>
    </c:forEach>
</body>
</html>