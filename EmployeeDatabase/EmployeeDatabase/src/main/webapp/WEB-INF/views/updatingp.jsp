<%@page language="java" %>
<html>
<%--<head> <a href="style.css"/> </head>--%>
<h1>RegisterEmployee</h1>
<form action="/updated" >

    <%--@declare id="empid"--%><%--@declare id="firstname"--%><%--@declare id="lastname"--%><%--@declare id="role"--%><%--@declare id="salary"--%><%--@declare id="name"--%><%--@declare id="id"--%><label for="empId">Enter Id : </label>
    <label for="Id">Enter Id: </label>
    <input type="number"  name="Id" value="${Id}"><br>
    <label for="Name">Enter Employee First Name : </label>
    <input type="text"  name="Name" value="${Name}"><br>
    <label for="lastName">Enter Employee Last Name : </label>
    <input type="submit" value="Submit">
</form>
</html>