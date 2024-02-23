<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.EmployeeDatabase.Entity.Employee"%> <!-- Change the import path to match your Employee class -->

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Employee List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Role</th>
        <th>Salary</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <%
        Map<Integer, Employee> employeeMap = (HashMap<Integer, Employee>) request.getAttribute("EmployeeMap");
        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            Employee employee = entry.getValue();
    %>
    <tr>
        <td > <%= employee.getEmpId() %></td>
        <td><%= employee.getFirstName() + " " + employee.getLastName() %></td>
        <td><%= employee.getRole() %></td>
        <td><%= employee.getSalary() %></td>

        <td >
            <form action="updateEmployee" style="background-color:darkgreen">
            <input type="hidden" name="employeeId" value= <%= employee.getEmpId() %>>
            <input type="submit" value="update" >
            </form>
        </td>
        <td >
            <form action="deleteEmployee" style="background-color:  crimson">
                <input type="hidden" name="employeeId" value= <%= employee.getEmpId() %>>
                <input type="submit" value="Delete" >
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
