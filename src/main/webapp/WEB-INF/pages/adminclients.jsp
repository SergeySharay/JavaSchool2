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
<c:url var="firstUrl" value="/adminclients?pageNumber=1"/>
<c:url var="lastUrl" value="/adminclients?pageNumber=${pages}"/>
<c:url var="prevUrl" value="/adminclients?pageNumber=${pageNumber - 1}"/>
<c:url var="nextUrl" value="/adminclients?pageNumber=${pageNumber + 1}"/>
<div class="container" id="adminclients">
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
                        <td>
                                ${client.permission == 2 ? "Покупатель" : "Сотрудник"}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<nav class="text-center">
    <ul class="pagination pagination-lg">
        <c:choose>
            <c:when test="${pageNumber == 1}">
                <li class="disabled"><a href="#"><i class="glyphicon glyphicon-fast-backward pagin"></i></a></li>
                <li class="disabled"><a href="#"><i class="glyphicon glyphicon-step-backward pagin"></i></a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}"><i class="glyphicon glyphicon-fast-backward pagin"></i></a></li>
                <li><a href="${prevUrl}"><i class="glyphicon glyphicon-step-backward pagin"></i></a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/adminclients?pageNumber=${i}"/>
            <c:choose>
                <c:when test="${i == pageNumber}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${pageNumber == pages}">
                <li class="disabled"><a href="#"><i class="glyphicon glyphicon-step-forward pagin"></i></a></li>
                <li class="disabled"><a href="#"><i class="glyphicon glyphicon-fast-forward pagin"></i></a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}"><i class="glyphicon glyphicon-step-forward pagin"></i></a></li>
                <li><a href="${lastUrl}"><i class="glyphicon glyphicon-fast-forward pagin"></i></a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
