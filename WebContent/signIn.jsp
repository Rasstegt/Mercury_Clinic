<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">    
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="FrontEnd/css/style.css">
		<title>Mercury Medical</title>
</head>

<body>
<div class="header">
	    <img src="FrontEnd/images/logo.png" style="width:600px">
	</div>
		<h1> Log In </h1>
		
	<div class="login">
	<div class="formBox">
		<form action="${pageContext.request.contextPath}/SystemController" method="post">
			<div class="row">
			<label>Username: </label>
			<input type='text' name="username" value="rray">
			</div>
			
			<div class="row">
			<label for='password'>Password: </label>
			<input type='password' name="password" value="password">
			</div>
			
			<div class="row">
			<input type="submit" value="Sign In" name="signIn">
			</div> 
		</form>
		
		<form action="FrontEnd/signUp.jsp">
			<div class="row">
				<input type="submit" value="Sign Up" name="signUp">
			</div> 
		</form>
	</div>
</div>
</body>
</html>