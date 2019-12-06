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
<div class="creation">
	<div class="header">
	    <img src="${pageContext.request.contextPath}/FrontEnd/images/logo.png" style="width:600px">
	</div>
		<h1> Create User Profile </h1>
		
		<div class="formBox">
		<form action="${pageContext.request.contextPath}/UserController" method="post">
			
			<div class="row">
				<label for='username'>Username: </label>
				<input type="text" name="username" placeholder="Username" required>
			</div>
			<div class="error">
			
			</div>
			
			<div class="row">
				<label for='password'>Password: </label>
				<input type="password" name="password" placeholder="Password" required>
			</div>
			
			<div class="row">
				<label for='password'>Confirm Password: </label>
				<input type="password" name="passwordConfirm" placeholder="Confirm your password" required>
			</div>

			<div class="row">
				<label for='fName'>First Name: </label>
				<input type="text" name="fName" placeholder="Your first name" required>
				
			</div>
			<div class="row">
				<label for='lName'>Last Name: </label>
				<input type="text" name="lName" placeholder="Your last name" required>
			</div>
			
			<div class="row">
			<label for='gender'>Gender: </label>
			<select name="gender" required>
	            <option value="M">Male</option>
	            <option value="F">Female</option>
        	</select>
			</div>
			
			<div class="row">
				<label for='dob'>Date Of Birth: </label>
				<input type="date" name="dateOfBirth" min="1920-01-01" required pattern="\d{4}-\d{2}-\d{2}" max="2019-12-31" required>
			</div>
			
			<div class="row">
				<label for='OHIPNumber'>OHIP Number: </label>
				<input type="number" name="ohipNum" min="8000000000" max="8999999999"  placeholder="8-123-456-789" required>
			</div>
			
			<div class="row">
			<label for='OHIPVersion'>OHIP Version: </label>
			<select name="ohipVer" required>
	            <option value="PL">PL</option>
	            <option value="CD">CD</option>
	            <option value="LK">LK</option>
	            <option value="QB">QB</option>
	            <option value="AB">AB</option>
	            <option value="WR">WR</option>
        	</select>
			</div>
		
			<input type="hidden" name="type" value="createProfile" >
			<input type="submit" name="createProfile" value="Create Profile">
			</form>
			<form action="${pageContext.request.contextPath}/signIn.jsp">
				<input type="submit" name="backToSignIn" value="Go Back">
			</form>
		</div>
</div>	
</body>
</html>