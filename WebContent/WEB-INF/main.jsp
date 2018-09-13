<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="model.User, model.Mutter" %>
<% User user = (User)session.getAttribute("user"); %>
<% List<Mutter> list = (List<Mutter>)application.getAttribute("list"); %>
<% String errmsg = (String)request.getAttribute("error"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p><%= user.getName() %>さんログイン中</p>
<a href="/docoTsubu/Logout">ログアウト</a>
<br>
<form action="/docoTsubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errmsg != null){ %>
	<p>つぶやきが入力されていません<p>
	<br>
<% } %>
<% for(Mutter mutter : list){ %>
	<p><%= mutter.getName() %> ： <%= mutter.getText() %></p>
<% } %>
</body>
</html>