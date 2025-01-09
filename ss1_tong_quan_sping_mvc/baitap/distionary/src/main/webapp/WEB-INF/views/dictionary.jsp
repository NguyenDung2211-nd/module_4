<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/9/2025
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>

        form {
            width: 350px;
            margin : 0 auto ;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        label {
            font-size: 16px;
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
        }


        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        h3 {
            font-size: 18px;
            font-weight: bold;
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        c\:if {
            text-align: center;
            margin-top: 10px;
        }

    </style>
</head>
<body>
<form action="/translate" method="post">
    <label>Nhập từ cần tra:</label>
    <input type="text" name="word" />
    <input type="submit" value="Tra từ" />
</form>

<c:if test="${not empty result}">
    <h3>Kết quả "${word}": ${result}</h3>
</c:if>
</body>
</html>
