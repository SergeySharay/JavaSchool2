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
<c:url var="firstUrl" value="/adminproducts?pageNumber=1"/>
<c:url var="lastUrl" value="/adminproducts?pageNumber=${pages}"/>
<c:url var="prevUrl" value="/adminproducts?pageNumber=${pageNumber - 1}"/>
<c:url var="nextUrl" value="/adminproducts?pageNumber=${pageNumber + 1}"/>
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
            <c:url var="pageUrl" value="/adminproducts?pageNumber=${i}"/>
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
            <div align="right">
                <form role="form" method="get" action="/site/adminproductadd" class="btn">
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
                            <form method="get" action="/site/adminproductpage" class="forbut">
                                <input type="submit" value="More">
                                <input type="hidden" name="productId" value="<c:out value="${product.id}"/>"></form>
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
            <c:url var="pageUrl" value="/adminproducts?pageNumber=${i}"/>
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
