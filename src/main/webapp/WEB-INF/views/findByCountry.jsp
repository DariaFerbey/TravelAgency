<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/21/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
    <h2>Find hotels in the country</h2>
    <h4>
        <c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>
    </h4>
    <br>
    <form action="${contextPath}/hotels/findHotel" method="get">
        <label for="countryLabel">Country name</label>
        <select id="countryLabel" name="country" onChange="this.form.submit()">
            <option value="" selected disabled hidden>Choose country</option>
            <c:forEach var="item" items="${countryList}">
                <option value="${item.name}">${item.name}</option>
            </c:forEach>
        </select>
        <br/>
    </form>

    <c:if test="${not empty hotels}">
        <table>
            <thead>
            <tr>
                Here you can see all hotels in the ${hotels[0].country.name}
            </tr>
            <tr>
                <th>Hotel name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotels}">
                <tr>
                    <td>${hotel.hotelName}</td>
                    <td>
                        <form action="${contextPath}/allHotelRooms/${hotel.id}" method="post">
                            <input type="submit" value="check a specific room" class="subm">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>

