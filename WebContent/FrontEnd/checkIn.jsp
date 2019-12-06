<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">    
        <meta charset="UTF-8">
	        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/FrontEnd/css/style.css">
	    <title>Mercury Medical</title>
</head>
<body>
	<div class="gridView">

		<jsp:include page="header.jsp" />
		<jsp:include page="menu.jsp" />
		
		<div class="formBox">
		<form action="${pageContext.request.contextPath}/CalendarController" method="post">
	
			<div class="row">
				<label for='username'>Username: </label>
				<p>${userInfo.login}</p>
			</div>

			<div class="row">
				<label for='name'>Name: </label>
				<p>${userInfo.fName} ${userInfo.lName}</p>
			</div>

			<div class="row">
				<label for='gender'>Gender: </label>
				<c:choose>
				<c:when test= "${userInfo.gender == 'M'}">
				<p>Male</p>
				</c:when>
				<c:otherwise>
				<p>Female</p>
				</c:otherwise>
				</c:choose>
			</div>
			
			<div class="row">
				<label for='dob'>Date Of Birth: </label>
				<p>${userInfo.dateOfBirth}</p>
			</div>
			
			<div class="row">
				<label for='OHIPNumber'>OHIP Number: </label>
				<p>${userInfo.ohipNumber}</p>
			</div>
			
			<div class="row">
				<label for='OHIPVersion'>OHIP Version: </label>
				<p>${userInfo.ohipVersion}</p>
			</div>
			
				<input type="submit" name="checkIn" value="Check In">
			</form>
			
			<form action="${pageContext.request.contextPath}/FrontEnd/updateProfile.jsp">
				<input type="submit" name="updateInfo" value="Update Info">	
			</form>
		</div>
		<form>
		</form>
</div>
</body>
</html>