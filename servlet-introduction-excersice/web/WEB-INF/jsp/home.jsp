<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome Home!</h1>
<%=session.getAttribute("username") == null
        ? "<h3>Login if you have an account, or Register if you don't!</h3>"
        : "<h3>Navigate through the application using the links below!</h3>"
%>
<hr/>
<% if (session.getAttribute("username") == null) { %>
<a href="/users/login">Login</a>
<br/>
<a href="/users/register">Register</a>
<% } else { %>
<a href="/animals/create">Create Cat</a>
<br/>
<a href="/animals/all">All Cats</a>
<br/>
<a href="/users/logout">Logout</a>
<% } %>
</body>
</html>