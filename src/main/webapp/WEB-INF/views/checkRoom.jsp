<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/30/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Travel agency</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <%@include file="header.jsp" %>
    <br>
    <h2>All Rooms</h2>
    <c:if test="${not empty errorMessage}">
        <h4><strong>${errorMessage}</strong></h4>
    </c:if>
    <table class="table">
        <thead>
        <tr>
            <th>Room number</th>
            <th>Room price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td align="center">${room.number}</td>
                <td align="center">${room.price}</td>
                <td>
                    <form action="${contextPath}/rooms/available_room/${room.number}" method="post">
                        <div>
                            <label for="dateOfArrival">Date of arrival</label>
                            <input type="date" name="checkIn" id="dateOfArrival" required>
                            <p>
                                <label for="dateOfDeparture">Date of departure</label>
                                <input type="date" name="checkOut" id="dateOfDeparture" required>
                            </p>
                            <p>
                                <input type="hidden" name="hotelId" value="${room.hotel.id}">
                            </p>
                            <input type="submit" value="Check the Room">

                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
