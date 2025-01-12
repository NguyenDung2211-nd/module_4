<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/12/2025
  Time: 2:04 PM
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
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        label {
            font-size: 1rem;
            margin-bottom: 8px;
            display: block;
            color: #555;
        }

        input[type="text"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 1rem;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 1.1rem;
        }

        button:hover {
            background-color: #45a049;
        }

        .result {
            margin-top: 20px;
            font-size: 1.2rem;
            color: #333;
            font-weight: bold;
        }

        .error {
            color: red;
            font-size: 1rem;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<form action="/operator" method="get">
    <label for="number1">Số thứ nhất:</label>
    <input type="text" name="number1" id="number1" required/><br/><br/>

    <label for="number2">Số thứ hai:</label>
    <input type="text" name="number2" id="number2" required/><br/><br/>

    <label for="operator">Phép toán:</label>
    <select name="operator" id="operator" required>
        <option value="+">Cộng</option>
        <option value="-">Trừ</option>
        <option value="*">Nhân</option>
        <option value="/">Chia</option>
    </select><br/><br/>

    <button type="submit">Tính</button>

    <div>
        <h3>Kết quả: ${result}</h3>
    </div>

    <div>
        <c:if test="${not empty error}">
            <h3 style="color: red;">Lỗi: ${error}</h3>
        </c:if>
    </div>
</form>
</body>
</html>
