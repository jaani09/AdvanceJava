<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <% UserBean user = (UserBean)session.getAttribute("user");%>
  <%
  if(user !=null){
  %>
  <h3> 
      hi,
        <%=user.getFirstName()%></h3>
  
  <b><a href="UserCtl"> Add User</a></b>
  <b><a href= "UserListCtl.do">UserList</a></b>
  <b><a href="LoginCtl?operation=logout">Logout</a></b>
  <%}else{%>
  
  <h3>hi,guest</h3>
  
  
  <%} %>
  <hr>
  
</body>
</html>