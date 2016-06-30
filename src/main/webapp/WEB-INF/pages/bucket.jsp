<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Корзина</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container">
    <div class="col-xs-12 col-sm-12 col-md-12">
        <div class="panel panel-default" id="order">
            <div class="panel-heading">Заказ</div>
            <div class="panel-body">
                <p>Ваша корзина пуста. Перейдите в каталог и добавьте товары в корзину.</p>
                <table class="table">
                    <tr>
                        <th>Наименование</th>
                        <th>Цена</th>
                        <th>Колличество</th>
                        <th>Сумма</th>
                    </tr>

                    <tr>
                        <td>
                        </td>
                        <td>
                        </td>
                        <td>
                            <form method="GET" action="Bucket" class="count_button">
                                <input class="btn minus" type="submit" name="Quantity" value="-1">

                                <div class="getv">
                                </div>
                                <input class="btn plus" type="submit" name="Quantity" value="+1">
                                <input type="hidden" name="ProductId" value=" ">
                            </form>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Общая стоимость</td>
                        <td>
                        </td>
                    </tr>
                </table>
                <p>

                <form method="get" action="../getorder.jsp" id="getorder"></form>
                <button type="submit" form="getorder" class="btn btn-primary">Оформить заказ</button>
                </p>
            </div>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
