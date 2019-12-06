<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date"%>

		<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate var="finalDate" type="date" value="${now}"/>
			
	<div class="header">
	<div class="column">
        <img src="${pageContext.request.contextPath}/FrontEnd/images/logo.png" style="max-width:600px; width: auto;">
	</div>
	<div class="column">
	<div class="row">
	<p>Name: ${userInfo.fName} ${userInfo.lName}</p>
	</div>
	<div class="row">
	<p><fmt:formatDate type = "both" dateStyle = "long" value = "${now}" /></p>
	</div>
	<div class="row">
	<a href="${pageContext.request.contextPath}/FrontEnd/updateProfile.jsp">Update Profile</a>
	<a href="${pageContext.request.contextPath}/signIn.jsp">Log out</a>
	</div>
	</div>
	</div>