<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--This is comment --%>
<h1>This is HTML</h1>
<%--This is comment --%>
<!-- system.out.println("This is java code"); -->
<%-- Script Tag --%>
<% System.out.println("This is My Java Code");%>

<%-- This is Declaration Tag --%>
<%!  int a=5; %>

<% int a=6; %>

<% System.out.println(this.a); %>

<%--This is Exression Tag --%>
<h1><%=new Random().nextInt(999) %></h1>
</body>
</html>