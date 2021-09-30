<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/22/2021
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav>
    <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <a class="nav-item nav-link" id="nav-home-tab" data-toggle="tab" href="${pageContext.request.contextPath}/home"
           role="tab" aria-controls="nav-home" aria-selected="true">Home</a>
        <sec:authorize access="hasAuthority('all_permissions')">
            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
               href="${pageContext.request.contextPath}/management" role="tab" aria-controls="nav-profile"
               aria-selected="false">Management</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p class="nav-item navbar-nav ml-auto" id="nav-logout-tab" data-toggle="tab">
                Welcome back, <sec:authentication property="name"/>!
            </p>
        </sec:authorize>
        <a class="nav-item nav-link navbar-nav ml-auto" id="nav-logout-tab" data-toggle="tab"
           href="${pageContext.request.contextPath}/"
           role="tab" aria-controls="nav-logout" aria-selected="false">Log out</a>
    </div>
</nav>