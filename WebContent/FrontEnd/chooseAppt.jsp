<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>
<sql:setDataSource var = "dataSource" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/mercury"
         user = "root"  password = ""/>
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
		<h1>Scheduled appointments: </h1>
		</div>
		
		<sql:query dataSource = "${dataSource}" var="result">
            SELECT * from appointments;
         </sql:query>
         
         
         <div class="formBox">
         <form action="${pageContext.request.contextPath}/CalendarController" method="post">
         <div class="row">
			<div class="column">
			<h3>Reason</h3>
			</div>
			<div class="column">
			<h3>Time</h3>
			</div>
		 </div>
		
         <c:forEach var="row" items="${result.rows}">
         <div class="apps">
			<input type="radio" name="apptNumber" value="${row.apptNumber}">
			<div class="row">
				<div class="column"><c:out value="${row.reasonForVisit}" /></div>
				<div class="column"><c:out value="${row.dateTime}" /></div>
			</div>
		</div>
         </c:forEach>
         
            <input type="hidden" name="click" value="checkIn" >
			<input type="submit" name="checkIn" value="Check In">
         
         </form>
         </div>
		
	</div>
</div>
</body>
</html>