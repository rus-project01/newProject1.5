<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Authorization</title>
</head>
<body>
<%
    ArrayList<User> list = (ArrayList<User>)request.getSession().getAttribute("us");
%>
<h1>Welcome: <%=list.get(0).getName()%>. Your password: <%=list.get(0).getPassword()%>. If you want to leave this website, push: </h1>
<form action="/login" method="post">
    <tr><td colspan="2"><input type="submit" value="Logout"/></td></tr>
</form>
</body>
</html>