<%@ page import="java.util.List" %><%--
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
Success!
    <% List<String> animals = (List<String>) application.getAttribute("names"); %>
    <% for(String animal : animals) {
        out.println("<h3>" + animal + "</h3>");
     } %>
</body>
</html>
