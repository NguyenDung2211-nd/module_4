<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/12/2025
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
            padding: 20px;
        }
        h2 {
            color: #4CAF50;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            background-color: #e7f7e7;
            margin: 5px 0;
            padding: 10px;
            border-radius: 5px;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #ffffff;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #45a049;
        }
        form {
            margin-top: 20px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
        }
        input[type="checkbox"] {
            margin-right: 10px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        p {
            color: red;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${not empty condiments}">
        <h2>You have selected the following condiments:</h2>
        <ul>
            <c:forEach items="${condiments}" var="condiment">
                <li>${condiment}</li>
            </c:forEach>
        </ul>
        <a href="/save">Go back to select condiments</a>
    </c:when>
    <c:otherwise>
        <h2>Select condiments for your sandwich:</h2>
        <c:if test="${submitted && not empty error}">
            <p style="color:red;">${error}</p>
        </c:if>
        <form action="save" method="post">
            <input type="checkbox" name="condiment" value="Lettuce">Lettuce<br>
            <input type="checkbox" name="condiment" value="Tomato">Tomato<br>
            <input type="checkbox" name="condiment" value="Mustard">Mustard<br>
            <input type="checkbox" name="condiment" value="Mayonnaise">Mayonnaise<br>
            <input type="submit" value="Save">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
