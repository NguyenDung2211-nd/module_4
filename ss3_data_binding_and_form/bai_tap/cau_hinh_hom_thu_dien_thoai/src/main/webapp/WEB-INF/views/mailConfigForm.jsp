<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 1/13/2025
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <head>
    <title>Title</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        align-items: center;
        height: 100vh;
      }

      h2 {
        text-align: left;
        color: #333;
      }

      form {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      td {
        padding: 10px;
        vertical-align: middle;
      }

      input[type="submit"],
      input[type="reset"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 15px;
        margin-right: 10px;
        border-radius: 5px;
        cursor: pointer;
      }

      input[type="reset"] {
        background-color: #dc3545;
      }

      input[type="submit"]:hover,
      input[type="reset"]:hover {
        opacity: 0.9;
      }

      td:first-child {
        text-align: right;
        padding-right: 10px;
        font-weight: bold;
        color: #555;
      }

      td[colspan="2"] {
        text-align: center;
      }

    </style>
  </head>
  <body>
  <h2>Mail Configuration Form</h2>
  <form:form method="post" action="/updateMailConfig" modelAttribute="mailConfig">
    <table>
      <tr>
        <td>Language:</td>
        <td>
          <form:select path="language">
            <form:option value="English" label="English" />
            <form:option value="Vietnamese" label="Vietnamese" />
            <form:option value="Japanese" label="Japanese" />
            <form:option value="Chinese" label="Chinese" />
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Page Size:</td>
        <td>
          <form:select path="pageSize">
            <form:option value="5" label="5" />
            <form:option value="10" label="10" />
            <form:option value="15" label="15" />
            <form:option value="25" label="25" />
            <form:option value="50" label="50" />
            <form:option value="100" label="100" />
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Enable Spam Filter:</td>
        <td><form:checkbox path="enableSpamFilter" /></td>
      </tr>
      <tr>
        <td>Signature:</td>
        <td><form:textarea path="signature" rows="5" cols="30" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Update" />
          <input type="reset" value="Cancel" />
        </td>
      </tr>
    </table>
  </form:form>
  </body>
</html>
