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
  String id = request.getParameter("id");
  String name = request.getParameter("name");
  String password = request.getParameter("password");
  String role = request.getParameter("role");
%>
<h1 border ="1" width="500" align="center">Java Authorization Service</h1>
<form action="/admin" method="get">
    <input type="hidden" name="id" value="<%=id%>"/>
    <input type="hidden" name="role" value="<%=role%>"/>
    <table border ="1" width="500" align="center">
        <tr><td>Name:</td><td>
            <input type="text" name="name" value="<%=name%>"/></td></tr>
        <tr><td>Password:</td><td>
            <input type="password" name="password" value="<%=password%>"/></td></tr>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Enter"/></td></tr>
    </table>
</form>
</body>
</html>