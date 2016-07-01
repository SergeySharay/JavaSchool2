<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default" id="order">
            <div class="panel-heading">
                Order №<c:out value="${orderPage.id}"/>
            </div>
            <div class="panel-body">
                <table class="table">
                    <tr>
                        <td>Client Id</td>
                        <td><c:out value="${orderPage.client.clientId}"/></td>
                    </tr>
                    <tr>
                        <td>Client</td>
                        <td>
                            <c:out value="${orderPage.client.name}"/>
                            <c:out value="${orderPage.client.surname}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Payment</td>
                        <td><c:out value="${orderPage.payment}"/></td>
                    </tr>
                    <tr>
                        <td>Delivery</td>
                        <td><c:out value="${orderPage.delivery}"/></td>
                    </tr>
                    <tr>
                        <td>Статус оплаты</td>
                        <td><c:out value="${orderPage.paymentStatus}"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>Order Status</td>
                        <td><c:out value="${orderPage.orderStatus}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Order Date</td>
                        <td><c:out value="${format.format(orderPage.orderDate)}"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Order Change
            </div>
            <div class="panel-body">
                <form role="form" method="POST" action="/site/adminorderpage">
                    <div class="form-group">
                        <input type="text" name="payment" class="form-control input-sm"
                               placeholder="Payment" maxlength="80">
                    </div>
                    <div class="form-group">
                        <input type="text" name="delivery" class="form-control input-sm"
                               maxlength="80" placeholder="Delivery">
                    </div>
                    <div class="form-group">
                        <input type="text" name="paymentstatus" class="form-control input-sm"
                               maxlength="80" placeholder="Payment Status">
                    </div>
                    <div class="form-group">
                        <input type="text" name="orderstatus" class="form-control input-sm"
                               maxlength="25" placeholder="Order Status">
                    </div>
                    <input type="hidden" name="orderId"
                           value="<c:out value="${orderPage.id}"/>">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Save" class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="col-xs-12 col-sm-12 col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">Order Details №<c:out value="${orderPage.id}"/>
            </div>
            <div class="panel-body"></div>
            <table class="table">
                <tr>
                    <th>Name</th>
                    <th>Price, Rub.</th>
                    <th>Quantity, Pcs.</th>
                </tr>
                <c:set var="sum" value="0"/>
                <c:forEach items="${orderPage.bucket}" var="orderProduct">
                    <tr>
                        <td><c:out value="${orderProduct.productId.name}"/></td>
                        <td><c:out value="${orderProduct.productId.price}"/></td>
                        <td><c:out value="${orderProduct.quantity}"/></td>
                        <c:set var="sum" value="${sum + orderProduct.productId.price * orderProduct.quantity}"/>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td>Total price, Rub.</td>
                    <td><c:out value="${sum}"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
