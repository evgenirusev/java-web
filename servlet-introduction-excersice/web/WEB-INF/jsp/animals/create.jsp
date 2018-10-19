<%--
  Created by IntelliJ IDEA.
  User: Evgeni
  Date: 10/19/2018
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create An Animal</title>
</head>
    <body>
        <h1>Create An Animal!</h1>
        <br/>
        <form method="post">
            Name:
            <input type="text" id="name" name="name"/>
            <br/>
            Breed:
            <input type="text" id="breed" name="breed"/>
            <br/>
            Color:
            <input type="text" id="color" name="color"/>
            <br/>
            Number of legs:
            <input type="number" id="legs" name="legs"/>
            <br/>
            <button type="submit">Create An Animal</button>
        </form>
        <hr/>
        <a href="#">Back to Home</a>
    </body>
</html>
