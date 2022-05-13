<%@page import="control.Food"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Pending</title>
</head>

<body>
	<form action="final" method="post">
		<h1 align="center">Order Pending...</h1>
		<table align="center">
			<tr>
				<td align="center">
					<input type=submit id=complete name=complete value="Pickup Order" formaction="finale">
				</td>
			</tr>
</table>
		
	</form>

</body>
</html>