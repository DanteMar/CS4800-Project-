<%@page import="control.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page import="objects.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Reservation</title>
</head>
<script>
	function add(){
		//total= total+(hotdog*document.getElementById('quantity'));
		//document.getElementById("OrderTotal").innerHTML=total;
		if(document.getElementById('quantity1')>0){
			out.println("ddd");
		}
	} 
	function addRow(){
		var RowNumber= document.getElementById("MenuTable").rows.length;
		var rowString = "quantity"+RowNumber;
		$("MenuTable").append('<td><input type="number" name="quantity' + RowNumber + '" id="quantity' + RowNumber + 'value="${'+rowString+'}"></td>')
		
	}
</script>
<body>
	
	<form action="add" method="post">

		<table id="MenuTable" bgcolor="#00ffff" width="600" height="800" align="center">
			<tr>
				<th>Food</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
					
					
			    <% 
			    ArrayList<Food> foods =(ArrayList<Food>) request.getAttribute("foods");%>
			 
			<c:forEach var="aFood" items="${foods}" varStatus="loop">
				<tr>
					<td>${aFood.name}</td>
					<td><c:out value="$ "></c:out>${aFood.price}</td>
					<td><input type=number name="quantity${loop.index}" id="quantity${loop.index}"></td>
				</tr>
			</c:forEach>
			<%--<td align="left"><c:set var="hotdog" value="Hotdog"></c:set> <c:out value="${hotdog}"></c:out></td>
			      <td align="center"><c:out value="$ "></c:out><c:set var="price1" value="5.5"></c:set> <c:out value="${price1}"></c:out></td>
			      <td align="right"><input type="number" id = "quantity1" name="quantity1" value="${quantity1}"></td>
				  <td align="right"><input type="submit" id="confirm1" name="confirm1" value="Confirm"
				   onclick="add();"></td> --%>

				<tr>
				<%-- <td align="left"><c:set var="soda" value="Soda"></c:set> <c:out value="${soda}"></c:out></td>
			      <td align="center"><c:out value="$ "></c:out><c:set var="price2" value="5"></c:set> <c:out value="${price2}"></c:out></td>
			      <td align="right"><input type="number" id = "quantity2" name="quantity2"value="${quantity2}"></td>
			      --%>
				  <td align="right"><input type="submit" id="confirm" name="confirm" value="Confirm"
				   onclick="add();"></td>
				   <td align="left"><input type="reset" id="reset" name="reset" value="Reset"
				   ></td>
				</tr>
			<h1 style="color: red;"> <c:out value="${requestScope.error}" /></h1>

	</form>
</body>
</html>