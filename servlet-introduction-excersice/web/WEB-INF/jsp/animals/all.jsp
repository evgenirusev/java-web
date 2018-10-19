<%@ page import="java.util.List" %>
<%@ page import="entities.Animal" %><%--
  Created by IntelliJ IDEA.
  User: Evgeni
  Date: 10/19/2018
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
    <h1>All Animals</h1>
    <hr>
    <%
        List<Animal> allAnimals = (List<Animal>) application.getContext("animals");

        for (Animal animal : allAnimals) { %>
            <h3><%= animal.getName() %></h3>
        <% }
    %>
</body>
</html>
