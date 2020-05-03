<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP画面</title>
</head>
<body>
<h1>メニュー</h1>
<c:choose>
<c:when test="${login.getId()==null}">
	<a href="/bulletinBoard/LoginServlet">ログイン</a><br>
	<a href="/bulletinBoard/RegisterServlet">ユーザー登録</a><br>
	<a href="/bulletinBoard/LoginServlet">スレッド作成</a><br>
	<a href="/bulletinBoard/LoginServlet">スレッド選択</a><br>
</c:when>
<c:otherwise>
	<c:out value="${login.id}"/>としてログイン中<br>
	<a href="/bulletinBoard/LogoutServlet">ログアウト</a>
	<form action= "/bulletinBoard/ThreadCreateServlet" method="post">
    スレッド作成 :
    スレッド名を入力してください<input type="text" name="name">  <input type="submit" value="作成">
    <c:if test="${not empty errorMsg}">
    	<p>${errorMsg}</p>
    </c:if>
    </form>
    スレッド選択<br>
    <c:forEach var="threadd" items="${threadList}">
	<a href="/bulletinBoard/ThreadCommentServlet?action=<c:out value="${threadd.getOid()}"/>"><c:out value="${threadd.getName()}"/></a>
  	<br><br>
    </c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>