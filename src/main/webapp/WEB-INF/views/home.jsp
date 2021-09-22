<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/20/2021
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Travel agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@include file="header.html" %>
<h2>Welcome to Travel Agency</h2>
<p>We are glad to see you here. Choose what you want to do here:</p>
<table class="table table-sm">
    <tbody>
        <tr>
            <td><a href="${contextPath}/countries/findHotelByCountry">Find hotel in different country </a></td>
        </tr>
        <tr>
            <td><a href="">Book available rooms on the concrete date </a></td>
        </tr>
        <tr>
            <td><a href="">Check if there are available rooms in hotel for period </a></td>
        </tr>

    </tbody>
</table>
</body>
</html>
