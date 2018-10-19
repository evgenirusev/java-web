<%@ page import="data.models.Animal" %>
<%@ page import="java.util.List" %>
<%@ page import="data.repositories.AnimalRepository" %><%--
  Created by IntelliJ IDEA.
  User: Evgeni
  Date: 10/19/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <%
        String animalName = request.getParameter("animalName");
        AnimalRepository allAnimals = (AnimalRepository) application.getAttribute("animals");
        Animal animal = null;

        for (Animal singleAnimal : allAnimals) {
            if (singleAnimal.getName().equals(animalName)) {
                animal = singleAnimal;
                break;
            }
        }
        // Handle null pointer
    %>

    <h1>Animal - <%=animal.getName()%></h1>
    <hr>
    <h3>Breed: <%=animal.getBreed()%></h3>
    <h3>Color: <%=animal.getColor()%></h3>
    <h3>Number of legs: <%=animal.getNumberOfLegs()%></h3>
    <hr>
    <a href="/">Back to Home</a>
</body>
</html>
