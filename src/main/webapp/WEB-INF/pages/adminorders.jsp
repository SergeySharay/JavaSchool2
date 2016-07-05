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
<c:url var="firstUrl" value="/adminorders?pageNumber=1"/>
<c:url var="lastUrl" value="/adminorders?pageNumber=${pages}"/>
<c:url var="prevUrl" value="/adminorders?pageNumber=${pageNumber - 1}"/>
<c:url var="nextUrl" value="/adminorders?pageNumber=${pageNumber + 1}"/>
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
            <c:url var="pageUrl" value="/adminorders?pageNumber=${i}"/>
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
<div class="container">
    <div class="panel panel-default" id="order">
        <div class="panel-heading">
            Orders
        </div>
        <div class="panel-body">
            <table class="table">
                <tr>
                    <th>Order Number</th>
                    <th>Client</th>
                    <th>Payment</th>
                    <th>Delivery</th>
                    <th>Payment Status</th>
                    <th>Order Status</th>
                    <th>Order Date</th>
                    <th>More</th>
                </tr>
                <c:forEach items="${ordersList}" var="orders">
                    <tr>
                        <td><c:out value="${orders.id}"/></td>
                        <td><c:out value="${orders.client.name}"/>
                            <c:out value="${orders.client.surname}"/></td>
                        <td><c:out value="${orders.payment}"/></td>
                        <td><c:out value="${orders.delivery}"/></td>
                        <td><c:out value="${orders.paymentStatus}"/></td>
                        <td><c:out value="${orders.orderStatus}"/></td>
                        <td><c:out value="${format.format(orders.orderDate)}"/></td>
                        <td>
                            <form method="get" action="/site/adminorderpage" class="forbut">
                                <input type="submit" value="More">
                                <input type="hidden" name="orderId" value="<c:out value="${orders.id}"/>"></form>
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
