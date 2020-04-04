<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Users List</title>
</head>
<body>
<%
  String id = request.getParameter("id");
  String name = request.getParameter("name");
  String password = request.getParameter("password");
  String money = request.getParameter("money");
  String role = request.getParameter("role");
%>
<h1>Create / Edit Form</h1>
<form action="/admin" method="post">
  <input type="hidden" name="id" value="<%=id%>"/>
  <table>
    <tr><td>Name:</td><td>
      <input type="text" name="name" value="<%=name%>"/></td></tr>
    <tr><td>Password:</td><td>
      <input type="password" name="password" value="<%=password%>"/></td></tr>
    <tr><td>Money:</td><td>
      <input type="text" name="money" value="<%=money%>"/></td></tr>
    <tr><td>Role :</td><td>
      <input type="text" name="role" value="<%=role%>"/></td></tr>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Create / Edit User"/></td></tr>
  </table>
</form>
<form action="/login" method="post">
  <h1>If you want to leave this website, push: </h1>
  <tr><td colspan="2"><input type="submit" value="Logout"/></td></tr>
</form>
<h1 border ="1" width="500" align="center">Users List</h1>
<%--<c:forEach items="${user}" var="qwe"><h1>${qwe.id}</h1></c:forEach>--%>
<%
  ArrayList<User> list = (ArrayList<User>)request.getSession().getAttribute("user");
  for(User users: list){
%>
<table border ="1" width="500" align="center">
  <tr bgcolor="00FF7F">
    <th><b>ID</b></th>
    <th><b>Name</b></th>
    <th><b>Password</b></th>
    <th><b>Money</b></th>
    <th><b>Role</b></th>
    <th><b>DeleteAction</b></th>
  </tr>
  <tr>
    <td><%= users.getId() %></td>
    <td><%= users.getName() %></td>
    <td><%= users.getPassword() %></td>
    <td><%= users.getMoney() %> рублей</td>
    <td><%= users.getRole() %></td>
    <td><a href="/delete?id=<%=users.getId()%>">Delete</a></td>
  </tr>
  <%}%>
</table>
</body>
</html>