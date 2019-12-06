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
	
	<div class="wrapper">
		
		<div class="row">
		<h1>Upcoming appointments</h1>
		</div>
		
		<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate var="finalDate" type="date" value="${now}"/>
			<p>Today is: ${finalDate}</p>
					
		<c:forEach var="row" items="${today}">
		<div class="apps">
			<div class="row">
			
			<div class="column">
			<div class="row">
			<h3>Reason</h3>
			</div>
			<c:out value="${row.reasonForVisit}" /></div>
			
			<div class="column">
			<div class="row">
			<h3>Time</h3>
			</div>
			<c:out value="${row.time}" /></div>
			</div>
			</div>
		</c:forEach>
	
	</div>
</div>
</body>
</html>