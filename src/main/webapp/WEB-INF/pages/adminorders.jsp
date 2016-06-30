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
                            <form method="get" action="#">
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
