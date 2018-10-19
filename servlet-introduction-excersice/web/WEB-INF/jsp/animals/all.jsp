<%@ page import="java.util.List" %>
<%@ page import="data.models.Animal" %><%--
  Created by IntelliJ IDEA.
  User: Evgeni
  Date: 10/19/2018
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Created Animals</title>
</head>
<body>
    <h1>All Animals</h1>
    <hr>
    <%
        List<Animal> allAnimals = (List<Animal>) application.getAttribute("animals");

        for (Animal animal : allAnimals) { %>
        <h3>
            <a href="/animals/profile?animalName=<%=animal.getName()%>" >
                <%= animal.getName() %>
            </a>
        </h3>
        <% }
    %>
    <hr>
    <a href="/">Back to Home</a>
</body>
</html>
