<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>在庫管理システム</title>
</head>
<body>
<h1>在庫管理システムログイン</h1>
<% if(loginUser != null) { %>
<p>ログインに成功しました</p>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<a href="/zaiko/Main">在庫管理システムへ</a>
<% } else { %>
<p>ログインに失敗しました</p>
<a href=""/>zaiko/">TOPヘ</a>
<% } %>
</body>
</html>