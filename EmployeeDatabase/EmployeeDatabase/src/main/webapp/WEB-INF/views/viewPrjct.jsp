<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.EmployeeDatabase.Entity.Employee"%>
<%@ page import="com.example.EmployeeDatabase.Entity.Project" %>
<!-- Change the import path to match your Employee class -->

<!DOCTYPE html>
<html>
<head>
    <title>Project List</title>
    <%--    <a href="style.css"/>--%>
</head>
<body>
<h1>Project List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>

    </tr>
    <%
        Map<Integer, Project> projectMap = (HashMap<Integer, Project>) request.getAttribute("ProjectMap");
        for (Map.Entry<Integer, Project> entry : projectMap.entrySet()) {
            Project project = entry.getValue();
    %>
    <tr>
        <td > <%=project.getId() %></td>
        <td><%= project.getName()  %></td>

        <td >
            <form action="updateProject" style="background-color:darkgreen">
                <input type="hidden" name="projectId" value= <%= project.getId() %>>
                <input type="submit" value="update" >
            </form>
        </td>
        <td >
            <form action="deleteProject" style="background-color:  crimson">
                <input type="hidden" name="projectId" value= <%= project.getId() %>>
                <input type="submit" value="Delete" >
            </form>
        </td>
    </tr>
    <% } %>
</table>

<a href="first">First Page</a>
</body>
</html>
