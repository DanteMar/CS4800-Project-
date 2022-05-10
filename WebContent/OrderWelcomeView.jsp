<%@page import="control.Food"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Welcome</title>
</head>

<body>
<h1 align="center">Welcome <br></br> Create an Order with the button below</h1>
<form action="setup" method="post">
	<table align="center">
	<tr>
		<td align="center">
			<input type=number id="id" name="id" value="BroncoID">
			<input type=submit id=complete name=complete value="Make Order">
		</td>
	</tr>
</table>
<h1 style="color: red;"> <c:out value="${requestScope.error}" /></h1>
</form>

</body>
</html>