<%@page import="control.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import = "objects.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
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
	
	<form action="checkout" method="post">
		<% ArrayList<MenuItem> foods =(ArrayList<MenuItem>) request.getAttribute("foods");%>
		<h1 align="center">Order Checkout</h1>
		<table bgcolor="#00ffff" width="800" height="800" align="center">
				<tr>
				<th>Food</th>
				<th>Quantity</th>
				<th>Price</th>
				</tr>
				
				
				<% 
				ArrayList<Food_Order> FO = new ArrayList<Food_Order>();
				ArrayList<String> Foodpart = new ArrayList<String>();
				ArrayList<String> Quantitypart = new ArrayList<String>();
				for(int i=0;i<foods.size();i++){
					String quan="quantity"+i;
					System.out.println(i+" "+request.getAttribute(quan));
					if(request.getAttribute(quan)==null)
						continue;
					if(Integer.valueOf((String)request.getAttribute(quan))>0){%>
						<tr>
						<td><%= foods.get(i).getName() %></td>
						<% Food_Order food_order= new Food_Order(foods.get(i).getID(),-1,Integer.valueOf((String)request.getAttribute(quan))); %>
						<td><%=request.getAttribute(quan) %></td>
						<td>$ <%=foods.get(i).getPrice() %></td>
						<% FO.add(food_order);%>
						</tr>
					 <%}
				}
				session.setAttribute("FO",FO);
				HttpSession s =request.getSession();
				int customerID = (Integer)s.getAttribute("customerID");
				System.out.println(customerID);
				//request.setAttribute("order",order);
				%>
				
				<%--<tr>
					<td>${aFood.name}</td>
					<td><c:out value="$ "></c:out>${aFood.price}</td>
					<td><input type=number name="quantity${loop.index}" id="quantity${loop.index}"></td>
				</tr> --%>
			    <tr valign="bottom">
			      <td><c:out value="Order Total: "></c:out></td>
			      <td><c:out value="$ "> </c:out><c:out value="${total}"></c:out></td>
			      <td><input type="hidden" id="id" name="id" value="${customerID}"></td>
					<td><input type="hidden" id="FO" name="FO" value="${FO}"></td>
				</tr>
				<tr>
					<td align="left">
					<input type="submit" name="restart" id="restart" value="Restart Order">
					</td>
					<td align="right">
					<%//ISSUES ARE HERE, THERE ARE TWO SUBMIT BUTTONS, TRYING TO GET EACH TO GO SOMEWHERE DIFF %>
					<%//GET 404 ERROR WHEN TRYING TO DO THE ONE BELOW %>
					<input type="submit" name="checkout" id="checkout" value="Checkout" formaction="final">
					</td>
					
				</tr>
		</table>
	</form>
</body>
</html>