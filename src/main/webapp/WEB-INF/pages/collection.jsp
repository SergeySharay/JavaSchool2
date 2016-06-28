<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>
<html lang="ru">
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Catalog</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="/site/"><i class="fa fa-home"></i></a></li>
                <li><a href="/site/catalog">Catalog</a></li>
                <li><a href="/site/catalog?Brands=<c:out value="${Brand}"/>"><c:out value="${Brand}"/></a></li>
                <li class="active"><a href="#"><c:out value="${Collection}"/></a></li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div class="row">
                <c:forEach items="${Collections}" var="collection">
                    <form role="form" method="GET" action="collection" class="btn">
                        <input type="submit" value="<c:out value="${collection}"/>" class="btn btn-primary">
                        <input type="hidden" name="Brand" value="<c:out value="${Brand}"/>">
                        <input type="hidden" name="Collection" value="<c:out value="${collection}"/>">
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>
    <hr>
</div>
<div class="container">
    <div class="row masonry" data-columns>
        <c:forEach items="${ProductsInCollection}" var="product">
            <div class="item">
                <div class="thumbnail">
                    <img src="resources/img/pic/<c:out value="${product.id}"/>.jpg" alt="">

                    <div class="caption">
                        <div id="blok4">
                            <form role="form" method="get" action="/site/product">

                                <input type="submit" value="Info" class="btn btn-info">
                                <input type="hidden" name="Product" value="<c:out value="${product.id}"/>">
                                <input type="hidden" name="Brand" value="<c:out value="${Brand}"/>">
                                <input type="hidden" name="Collection" value="<c:out value="${Collection}"/>">
                            </form>
                        </div>
                        <form role="form" method="get" action="#">
                            <div id="blok1" class="btn btn-primary">
                                <c:out value="${product.name}"/>
                            </div>
                            <div id="blok2" class="btn btn-primary">
                                <c:out value="${product.price}"/>
                            </div>
                            <p align="right">
                                <input type="submit" value="Buy" class="btn btn-success buyitem">
                                <input type="hidden" name="Brand" value="<c:out value="${Brand}"/>">
                                <input type="hidden" name="Collection" value="<c:out value="${Collection}"/>">
                                <input type="hidden" name="Product" value="<c:out value="${product.id}"/>">
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/salvattore.min.js"></script>
</body>
</html>