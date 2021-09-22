<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/22/2021
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Travel Agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <%@include file="header.jsp" %>
    <br>
    <h1>Management</h1>
    <table class="table table-striped">
        <c:forEach var="booking" items="${all}">
            <tr>
                <th>Room</th>
                <th>Hotel</th>
                <th>Checkin</th>
                <th>Checkout</th>
                <th></th>
            </tr>
            <tr>
                <td><c:out value="${booking.room.id}"/></td>
                <td><c:out value="${booking.room.hotel.hotelName}"/></td>
                <td><c:out value="${booking.checkIn}"/></td>
                <td><c:out value="${booking.checkOut}"/></td>
                <td><a href="<c:url value="/booking/delete/${booking.id}"/>">Cancel booking</a></td>
                    <%--            <td><a href="/booking/delete/${booking.id}">Cancel booking</a></td>--%>
            </tr>
        </c:forEach>
        <c:if test="${empty all}">
            User don't have any bookings.
        </c:if>
    </table>
</div>
</body>
</html>
