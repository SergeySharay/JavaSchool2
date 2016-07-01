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
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Топ 10 товаров
            </div>
            <div class="panel-body privatetable">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Наименование</th>
                        <th>Сколько куплено</th>
                    </tr>
                    <c:forEach items="${productLongMap}" var="product">
                        <tr>
                            <td>${product.key.id}</td>
                            <td>${product.key.name}</td>
                            <td>${product.value}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Топ 10 клиентов
            </div>
            <div class="panel-body">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Имя,Фамилия</th>
                        <th>Количество заказов</th>
                    </tr>
                    <c:forEach items="${ordersLongMap}" var="orders">
                        <tr>
                            <td>${orders.key.clientId}</td>
                            <td>${orders.key.name} ${orders.key.surname}</td>
                            <td>${orders.value}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Заказы за неделю
            </div>
            <div class="panel-body privatetable">
                <table class="table">
                    <tr>
                        <th>Id Заказа</th>
                        <th>Клиент</th>
                        <th>Дата</th>
                    </tr>
                    <c:forEach items="${ordersListDate}" var="orders">
                        <tr>
                            <td>${orders.id}</td>
                            <td>${orders.client.name} ${orders.client.surname} </td>
                            <td>${format.format(orders.orderDate)}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Заказы за 4 недели
            </div>
            <div class="panel-body privatetable">
                <table class="table">
                    <tr>
                        <th>Id Заказа</th>
                        <th>Клиент</th>
                        <th>Дата</th>
                    </tr>
                    <c:forEach items="${ordersListDateMonth}" var="orders">
                        <tr>
                            <td>${orders.id}</td>
                            <td>${orders.client.name} ${orders.client.surname} </td>
                            <td>${format.format(orders.orderDate)}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
