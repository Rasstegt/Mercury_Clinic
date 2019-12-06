<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <title>Mercury Medical</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/FrontEnd/css/style.css">
</head>
<body>
<div class="gridView">
		
		<jsp:include page="header.jsp" />
		<jsp:include page="menu.jsp" />
		
		<div class="formBox">
		<form action="${pageContext.request.contextPath}/UserController" method="post">
			
			<div class="column">
			
			<div class="row">
				<label for='username'>Username: </label>
				<input type="text" name="username" value="${userInfo.login}" readonly>
			</div>
			
			<div class="row">
				<label for='password'>Password: </label>
				<input type="password" name="password">
			</div>

			<div class="row">
				<label for='fName'>FirstName: </label>
				<input value="${userInfo.fName}" type="text" name="fName">
				
			</div>
			<div class="row">
				<label for='lName'>Last Name: </label>
				<input value="${userInfo.lName}" type="text" name="lName">
			</div>

		</div>
		<div class="column">
			<div class="row">
			<label for='gender'>Gender: </label>
			<select name="gender">
				<option selected value="${userInfo.gender}">${userInfo.gender}</option>
                <option value="M">Male</option>
	            <option value="F">Female</option>
        	</select>
			</div>
			
			<div class="row">
				<label for='dob'>Date Of Birth: </label>
				<p>${userInfo.dateOfBirth}</p>
			</div>
			
			<div class="row">
				<label for='OHIPNumber'>OHIP Number: </label>
				<input type="text" name="ohipNum" value="${userInfo.ohipNumber}" readonly>
			</div>
			
			<div class="row">
			<label for='OHIPVersion'>OHIP Version: </label>
			<select name="ohipVer">
				<option selected value="${userInfo.ohipVersion}">${userInfo.ohipVersion}</option>
	            <option value="PL">PL</option>
	            <option value="CD">CD</option>
	            <option value="LK">LK</option>
	            <option value="QB">QB</option>
	            <option value="AB">AB</option>
	            <option value="WR">WR</option>
        	</select>
			</div>
			</div>
		
			<input type="hidden" name="type" value="updateInfo">
			<input type="submit" name="updateInfo" value="Update Profile">
		
		</form>
		</div>
</div>	
</body>
</html>