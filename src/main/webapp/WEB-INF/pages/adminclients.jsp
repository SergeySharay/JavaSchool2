<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Administration</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<%@ include file="/WEB-INF/jsp/cabinetbar.jsp" %>
<%@ include file="/WEB-INF/jsp/cabinetbaradmin.jsp" %>

<div class="container">
    <div class="panel panel-default" id="order">
        <div class="panel-heading">
            Clients
        </div>
        <div class="panel-body">
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Brthday</th>
                    <th>Status</th>
                    <th>Change Status</th>
                </tr>
                <c:forEach items="${clientList}" var="client">
                    <tr>
                        <td><c:out value="${client.clientId}"/></td>
                        <td><c:out value="${client.name}"/></td>
                        <td><c:out value="${client.surname}"/></td>
                        <td><c:out value="${client.email}"/></td>
                        <td>
                                ${client.birthday == null ? "Отсутсвует" : format.format(client.birthday)}
                        </td>
                        <td><c:out value="${client.permission}"/></td>
                        <td>
                            <form method="post" action="#">
                                <input type="submit" value="изменить">
                                <input type="hidden" name="clientId" value="<c:out value="${client.clientId}"/>"></form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
