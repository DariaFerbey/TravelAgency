<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/16/2021
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>TravelAgency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@include file="header.html" %>
<br>
<div class="container">
    <div>
        <h2 align="center">All users and their orders </h2>
        <table class="table">
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <th>Username</th>
                </tr>
                <tr>
                    <td>${user.fullName} </td>
                </tr>
                <tr>
                    <th>Orders</th>
                </tr>
<%--                <c:if test="${user.bookings.size() == 0}">--%>
<%--                    <tr>No orders</tr>--%>
<%--                </c:if>--%>
<%--                <c:if test="${user.bookings.size() != 0}">--%>
                    <c:forEach var="book" items="${user.booking}">
                        <tr>
                            <th>Date of arrival</th>
                            <th>Date of departure</th>
                            <th>Hotel name</th>
                            <th>Room number</th>
                        </tr>
                        <tr>
                            <td>${book.checkIn}</td>
                            <td>${book.checkOut}</td>
                            <td>${book.room.hotel.hotelName}</td>
                            <td>${book.room.number}</td>
                        </tr>
                    </c:forEach>
<%--                </c:if>--%>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
