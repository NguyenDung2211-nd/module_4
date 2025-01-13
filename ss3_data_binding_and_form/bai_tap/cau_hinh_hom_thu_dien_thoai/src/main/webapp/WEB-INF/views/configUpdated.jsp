<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/13/2025
  Time: 3:33 PM
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
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }

        h2 {
            color: #28a745;
            margin-bottom: 20px;
        }

        p {
            color: #333;
            margin: 10px 0;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
<h2>Mail Configuration Updated Successfully!</h2>
<p>Language: ${updateMailConfig.language}</p>
<p>Page Size: ${updateMailConfig.pageSize}</p>
<p>Enable Spam Filter: ${updateMailConfig.enableSpamFilter}</p>
<p>Signature: ${updateMailConfig.signature}</p>

<a href="/mailConfig">Back to Config Form</a>
</body>
</html>
