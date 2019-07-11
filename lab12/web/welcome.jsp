<%--
  Created by IntelliJ IDEA.
  User: 610118
  Date: 7/11/2019
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>


<br>
<br>
<br>


    <%
        if (session != null) {
            if (session.getAttribute("userInfo") != null) {
                String name = (String) session.getAttribute("user");
                out.print("Hello, " + name + "  Welcome !");
            } else {
                response.sendRedirect("/login");
            }
        }
    %>
</br>
</br>
<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>