<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 10/1/2021
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>TravelAgency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>The room is available book now!</h2>
    <h3>Do you really want to book this room from ${checkIn.toString()} to ${checkOut.toString()}</h3>
    <form action="${contextPath}/rooms/available_room/${id}/roomBooking" method="post">
        <input type="hidden" name="checkIn" value="${checkIn.toString()}">
        <input type="hidden" name="checkOut" value="${checkOut.toString()}">
        <input class="btn btn-light" type="submit" value="Book room now">
    </form>
</div>
</body>
</html>
