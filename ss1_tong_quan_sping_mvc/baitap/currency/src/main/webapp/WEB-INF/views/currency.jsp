<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/9/2025
  Time: 2:45 PM
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
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      width: 300px;
      text-align: center;
    }

    h2 {
      font-size: 24px;
      color: #333;
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      font-weight: bold;
      color: #555;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin: 8px 0 15px 0;
      border: 1px solid #ddd;
      border-radius: 4px;
      font-size: 16px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #007BFF;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      width: 100%;
    }

    input[type="submit"]:hover {
      background-color: #0056b3;
    }

    p {
      font-size: 18px;
      color: #333;
    }

    p#error {
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>
<form action="/converts" method="post">
  <label>Tỉ giá (VND/USD):</label>
  <input type="text" name="rate" required /><br/>
  <label>Số lượng USD:</label>
  <input type="text" name="usd" required /><br/>
  <input type="submit" value="Chuyển đổi" />
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<c:if test="${not empty vnd}">
  <p>Kết quả : ${usd} USD = <c:out value="${vnd}" /> VND</p>
</c:if>
</body>
</html>
