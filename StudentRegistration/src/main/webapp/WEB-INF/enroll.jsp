<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
 background-color: #d5d5d5;
}
</style>
</head>
<body>
<form action="EnrollButtonCheck" method="post">
<p>Courses: <select name="courses">
${list2}
					</select></p>
<p>Grade: <select name="grade">
			<option value="A">A</option>
		    <option value="B">B</option>
			<option value="C">C</option>
			<option value="D">D</option>
			<option value="F">F</option>
		  </select>
</p>
<input class="button" type="submit" name="action" value="Exit">
<input class="button" type="submit" name="action" value="Drop">
<input class="button" type="submit" name="action" value="Register">
</form>


</body>
</html>