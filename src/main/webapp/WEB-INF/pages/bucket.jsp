<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Cart</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container">
    <div class="col-xs-12 col-sm-12 col-md-12">
        <div class="panel panel-default" id="order">
            <div class="panel-heading">Order</div>
            <div class="panel-body">
                <p>Ваша корзина пуста. Перейдите в каталог и добавьте товары в корзину.</p>
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                    </tr>
                    <c:set var="sum" value="0"/>
                    <c:if test="${not empty Cart}">
                        <c:forEach items="${Cart}" var="entry">
                            <tr>
                                <td>${entry.key.name}</td>
                                <td>${entry.key.price}</td>
                                <td>
                                    <form method="GET" action="#" class="count_button">
                                        <input class="btn minus" type="submit" name="Quantity" value="0">

                                        <div class="getv">${entry.value}</div>
                                        <input class="btn plus" type="submit" name="Quantity" value="1">
                                        <input type="hidden" name="ProductId" value=" ">
                                    </form>
                                </td>
                                <td>${entry.key.price*entry.value}</td>
                                <c:set var="sum" value="${sum}+${entry.key.price*entry.value}"/>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total price</td>
                        <td></td>
                    </tr>
                </table>
                <p>

                <form method="get" action="#" id="getorder"></form>
                <button type="submit" form="getorder" class="btn btn-primary">Checkout</button>
                </p>
            </div>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
