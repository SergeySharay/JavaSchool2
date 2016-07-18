<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Catalog</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="row">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="/site/">
                <i class="fa fa-home"></i>
            </a></li>
            <li><a href="/site/catalog">Catalog</a></li>
            <li><a href="/site/catalog">Brands</a></li>
            <li class="active"><a href="/site/filter">Filter</a></li>
        </ol>
    </div>
</div>
<div class="container">
    <div class="col-xs-12">
        <div class="row masonry" data-columns>
            <div class="item">
                <div class="thumbnail">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Parameters</h3>
                        </div>
                        <div class="panel-body privatetable">
                            <div class="container">
                                <form id="filter" role="form" method="POST" action="/site/filter" class="btn">
                                    <select class="filter" id="filter1" name="brand">
                                        <option selected value="">Brand</option>
                                        <c:forEach items="${FilterBrands}" var="brand">
                                            <option value="<c:out value="${brand}"/>"><c:out
                                                    value="${brand}"/></option>
                                        </c:forEach>
                                    </select>
                                    <select class="filter" id="filter2" name="col">
                                        <option selected value="">Collection</option>
                                        <c:forEach items="${FilterCollections}" var="collection">
                                            <option value="<c:out value="${collection}"/>"><c:out
                                                    value="${collection}"/></option>
                                        </c:forEach>
                                    </select>
                                    <select class="filter" id="filter3" name="price">
                                        <option selected value="">Price</option>
                                        <option value="1">До 500</option>
                                        <option value="2">от 500 до 1500</option>
                                        <option value="3">от 1500</option>
                                    </select>
                                    <select class="filter" id="filter4" name="weight">
                                        <option selected value="">Weight</option>
                                        <option value="1">до 5</option>
                                        <option value="2">от 5 до 10</option>
                                        <option value="3">от 10 до 15</option>
                                        <option value="4">от 15</option>
                                    </select>
                                    <select class="filter" id="filter5" name="length">
                                        <option selected value="">Length</option>
                                        <option value="1">До 20</option>
                                        <option value="2">от 20 до 30</option>
                                        <option value="3">от 30 до 40</option>
                                        <option value="4">более 40</option>
                                    </select>
                                    <select class="filter" id="filter6" name="width">
                                        <option selected value="">Width</option>
                                        <option value="1">до 10</option>
                                        <option value="2">от 10 до 20</option>
                                        <option value="3">от 20 до 30</option>
                                        <option value="4">от 30</option>
                                    </select>
                                    <select class="filter" id="filter7" name="color">
                                        <option selected value="">Color</option>
                                        <c:forEach items="${FilterColors}" var="color">
                                            <option value="<c:out value="${color}"/>"><c:out
                                                    value="${color}"/></option>
                                        </c:forEach>
                                    </select>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="submit" value="Select" class="btn btn-primary">
                                    <input type="hidden" name="Brands" value="">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:forEach items="${FilterProducts}" var="product">
                <div class="item">
                    <div class="thumbnail">
                        <img src="resources/img/pic/<c:out value="${product.id}"/>.jpg" alt="">

                        <div class="caption">
                            <form role="form" method="GET" action="/site/addProduct">

                                <div id="blok1" class="btn btn-primary">
                                    <c:out value="${product.name}"/>
                                </div>
                                <div id="blok2" class="btn btn-primary">
                                    <c:out value="${product.price}"/>
                                </div>
                                <p align="right">
                                    <input type="hidden" name="Page" value="/filter">
                                    <input type="submit" value="Buy" class="btn btn-success buyitem">
                                    <input type="hidden" name="Product" value="<c:out value="${product.id}"/>">
                                </p></form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/salvattore.min.js"></script>
</body>
</html>
