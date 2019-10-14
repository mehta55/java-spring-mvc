<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.dto.Flight" %>
    
<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
.result {
	width: 100%;
	border-collapse: collapse;
	background-color: #f2f2f2;
}

.result td {
	text-align: center;
	height: 25px;
	border: 1px solid black;
}

th {
	text-align: center;
	height: 50px;
	border: 1px solid black;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
  background-color: #4169E1;
}
</style>
		<meta charset="ISO-8859-1">
		<title>result</title>
	</head>
	<body>
		
		<c:if test="${searchResult.size() != 0}">
			<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>
								<c:out value="${searchResult.size()}"></c:out> matching flights found!
							</h2>
						</td>
						<td align = "right">
							<form action="SignOut">
							<input type = "submit" value = "SignOut"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
			<table class = "result">
			<tr>
				<th> FLIGHT NUMBER </th>
				<th> ARRIVAL LOCATION </th>
				<th> DEPARTURE LOCATION </th>
				<th> VALID TILL </th>
				<th> FLIGHT TIME </th>
				<th> FLIGHT DURATION </th>
				<th> FARE </th>
				<th> SEAT AVAILABILITY </th>
				<th> CLASS </th>
			</tr>
			<c:forEach items = "${searchResult}" var = "flight">
				<tr >
  					<td>${flight.getFlightNumber()}</td>
  					<td>${flight.getArrivalLocation()}</td>
  					<td>${flight.getDepartLocation()}</td>
  					<td>${flight.getFlightDate()}</td>
  					<td>${flight.getFlightTime()}</td>
  					<td>${flight.getFlightDuration()}</td>
  					<td>${flight.getFare()}</td>
  					<td>${flight.getSeatAvailablility()}</td>
  					<td>${flight.getFlightClass()}</td>
				</tr>
  			</c:forEach>
		
		</table>
		</c:if>
		<c:if test="${searchResult.size() == 0}">
			<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>
								Sorry! No matching flights found!
							</h2>
						</td>
						<td align = "right">
							<form action="SignOut">
							<input type = "submit" value = "SignOut"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
		</c:if>
		<br>
	</body>
</html>