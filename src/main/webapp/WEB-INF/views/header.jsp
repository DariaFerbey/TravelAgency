<%--
  Created by IntelliJ IDEA.
  User: dferb
  Date: 9/22/2021
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <a class="nav-item nav-link" id="nav-home-tab" data-toggle="tab" href="${pageContext.request.contextPath}/" role="tab" aria-controls="nav-home" aria-selected="true">Home</a>
        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="${pageContext.request.contextPath}/management" role="tab" aria-controls="nav-profile" aria-selected="false">Management</a>
    </div>
</nav>

<%--<script>--%>
<%--    $('#myTab a').on('click', function (e) {--%>
<%--        e.preventDefault()--%>
<%--        $(this).tab('show')--%>
<%--    })--%>
<%--</script>--%>
