<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Cabinet</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<%@ include file="/WEB-INF/jsp/cabinetbar.jsp" %>
<div class="container orders-all">
    <c:set var="c" value="1"/>
    <c:forEach items="${OrdersSet}" var="orders">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-md-4">
                <div class="panel panel-default marg" id="order">

                    <div class="panel-heading order-hidding" data-id="<c:out value="${c}"/>">
                        Заказ №<c:out value="${orders.id}"/>
                    </div>
                    <div class="panel-body order-class" data-id="<c:out value="${c}"/>">
                        <table class="table">
                            <tr>
                                <td>Payment</td>
                                <td><c:out value="${orders.payment}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Delivery</td>
                                <td><c:out value="${orders.delivery}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Payment Status</td>
                                <td><c:out value="${orders.paymentStatus}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Order Status</td>
                                <td><c:out value="${orders.orderStatus}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Order Date</td>
                                <td><c:out value="${format.format(orders.orderDate)}"/></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-8 col-md-8">
                <div class="panel panel-default order-class" data-id="<c:out value="${c}"/>">
                    <div class="panel-heading">Order Details №<c:out value="${orders.id}"/></div>
                    <div class="panel-body"></div>
                    <table class="table">
                        <tr>
                            <th>Name</th>
                            <th>Quantity, Pcs</th>
                            <th>Price, Rub.</th>

                        </tr>
                        <c:set var="sum" value="0"/>
                        <c:forEach items="${orders.getBucket()}" var="orderProduct">
                            <tr>
                                <td><c:out value="${orderProduct.productId.name}"/></td>
                                <td><c:out value="${orderProduct.quantity}"/></td>
                                <td><c:out value="${orderProduct.productId.price}"/></td>
                                <c:set var="sum" value="${sum + orderProduct.productId.price * orderProduct.quantity}"/>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td>Total Price, Rub.</td>
                            <td><c:out value="${sum}"/></td>
                        </tr>
                    </table>

                    <form method="post" action="#" class="privatetable feat">
                        <input type="submit" class="btn btn-primary" value="Повторить заказ">
                        <input type="hidden" name="orderId" value="<c:out value="${orders.id}"/>">
                    </form>

                    <form method="get" action="/site/cabinetpayment" class="privatetable feat">
                        <input type="submit" class="btn btn-primary" value="Оплатить заказ">
                        <input type="hidden" name="summer" value="<c:out value="${sum}"/>">
                    </form>

                </div>
            </div>
        </div>
        <c:set var="c" value="${c+1}"/>
    </c:forEach>
</div>
<script type="text/javascript">
    jQuery(document).ready(function () {
        jQuery('.orders-all .order-hidding').click(function () {
            var this_id = jQuery(this).attr("data-id");
            jQuery('.order-hidding').removeClass('active');
            jQuery(this).toggleClass('active');
            jQuery('.order-class').removeClass('active');
            jQuery('[data-id = ' + this_id + ']').addClass('active');
        });
    });
</script>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
