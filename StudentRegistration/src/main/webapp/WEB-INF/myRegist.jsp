<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Beans.EnrollBean" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
 background-color: #d5d5d5;
}
#enrollTable th{
padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: black;
  color: white;
}
#enrollTable tbody{
background-color: white;}
.divForm{
display: flex;
    justify-content: space-between;
    margin-top: 5px;
    max-width: 280px;
   
}

</style>
</head>
<body>
<p>Name: ${student.fname} ${student.lname} Phone #: ${student.phone}</p>
<table id="enrollTable">
        <thead>
            <tr>
                <th>Course ID</th>
                <th>Title</th>
                <th>Grade</th>
            
            </tr>
        </thead>
        <tbody>
        <%List<EnrollBean> list = (ArrayList<EnrollBean>) session.getAttribute("list");%>
        
        <% for (int i=0;i<list.size();i++) { %>
            <tr>
            
                <td><%= list.get(i).getCourseID() %></td>
                <td><%= list.get(i).getTitle() %></td>
                <td><%= list.get(i).getGrade() %></td>
            </tr>
        <% } %>
    </tbody>
    </table>
    <div></div>
    <div class="divForm">
    <form action="regisLogin.jsp">
        <input class="button" type="submit" value="Exit" />
    </form>
    <form action="EnrollButtonCheck">
        <input class="button" type="submit" name="action" value="Enroll">
    </form>
</div>
       
</body>
</html>