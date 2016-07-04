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
                Top 10 Products
            </div>
            <div class="panel-body privatetable">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Quantity</th>
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
                Top 10 Clients
            </div>
            <div class="panel-body">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>First Name, Last Name</th>
                        <th>Orders</th>
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
                Orders For A Week.
            </div>
            <div class="panel-body privatetable">
                <table class="table">
                    <tr>
                        <th>Order Id</th>
                        <th>Client</th>
                        <th>Date</th>
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
                Orders For Two Weeks.
            </div>
            <div class="panel-body privatetable">
                <table class="table">
                    <tr>
                        <th>Order Id</th>
                        <th>Client</th>
                        <th>Date</th>
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
