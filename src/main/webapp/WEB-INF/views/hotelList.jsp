<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/20/2021
  Time: 9:55 AM
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
<br>
<div class="container">
    <%@include file="header.jsp" %>
    <br>
    <div>
        <h2 align="center">All Hotels</h2>
        <table class="table">
        <thead>
            <tr>
                <th>Hotel name</th>
                <th>Country</th>
                <th colspan="4"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotels}">
                <tr>
                    <td>${hotel.hotelName}</td>
                    <td>${hotel.country.name}</td>
                    <td><a href="${contextPath}/hotels/updateHotel/${hotel.id}">Edit</a></td>
                    <td><a href="${contextPath}/hotels/deleteHotel/${hotel.id}">Delete</a></td>
                    <td><a href="${contextPath}/addRoom/${hotel.id}">Add room</a></td>
                    <td><a href="${contextPath}/allHotelRooms/${hotel.id}/">View all rooms</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

<%--        <td><a href="${contextPath}/hotels/addHotel">Add</a></td>  --%>
<%--    <p><a href="<c:url value="${contextPath}/addHotel"/>">Add hotel</a></p>--%>
</div>
</body>

</html>
