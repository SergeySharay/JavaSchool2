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
            <div align="right">
                <form role="form" method="get" action="#" class="btn">
                    <input type="submit" value="Add New Product" class="btn btn-info">
                </form>
            </div>
        </div>
        <div class="panel-body">
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Brand</th>
                    <th>Collection</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>More</th>
                </tr>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td><c:out value="${product.id}"/></td>
                        <td><c:out value="${product.brand}"/></td>
                        <td><c:out value="${product.collection}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td>
                            <form method="get" action="#">
                                <input type="submit" value="More">
                                <input type="hidden" name="productId" value="<c:out value="${product.id}"/>"></form>
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
