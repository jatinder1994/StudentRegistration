<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
 background-color: #d5d5d5;
}
</style>
</head>
<body>
<h2>Login</h2>

    <form action="validateLogin" method="post">
        <label for="ssn">SSN:</label>
        <input type="text" id="ssn" name="ssn" required><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>