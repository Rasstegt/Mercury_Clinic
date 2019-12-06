<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">    
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Mercury Medical</title>
</head>
<body>
<div class="gridView">
		<jsp:include page="header.jsp" />
		<jsp:include page="menu.jsp" />
	
	
	<div class="scheduleAppointment">
		<div class="row">
		<h1>Schedule an Appointment</h1>
		</div>
		<div class="formBox">
		<form action="${pageContext.request.contextPath}/CalendarController" method="post">
			
			<div class="row">
			<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate var="minimalDate" pattern="yyyy-MM-dd" value="${now}" />
			
			<label for='date'>Date: </label>
			<input type='date' name='date' placeholder="Date goes here" min="${minimalDate}" max="2020-02-02"
			required pattern="\d{4}-\d{2}-\d{2}" required>
			</div>
			<div class="row">
			<label for='time'>Time: </label>
			<input type='time' name="time" max="12" min="5" placeholder="Time goes here" required><br> 
			</div>
			<div class="row">
			<label for='time'>Reason: </label>
				<select id='reason' name='reason'>
	                 <option value="Headache" name='headache'>Headache</option>                
	                 <option value="Check" name='check'>Check</option>
	                 <option value="Backpain" name='backpain'>Back Pain</option>
	                 <option value="Sorethroat" name='sorethroat'>Sore throat</option>
                </select>
            </div>
            <div class="row">
            <input type="hidden" name="click" value="scheduleAppointment" >
			<input type="submit" name="schedule" value="Schedule">
			</div>
		</form>
		</div>
	</div>
</div>

</body>
</html>