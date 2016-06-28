<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %><!-- header -->
    <title>Catalog</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<!-- навигация -->

<div class="container">
    <div class="row">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="/site/">
                    <i class="fa fa-home"></i>
                </a></li>
                <li><a href="/site/catalog">Catalog</a></li>
                <li class="active"><a href="/site/catalog">Brands</a></li>
            </ol>
        </div>
    </div>
    <!-- хлебные крошки-->
    <div class="row">
        <form role="form" method="get" action="Filter" class="btn">
            <input type="submit" value="Search" class="btn btn-info">
        </form>
        <c:forEach items="${catalogMenuBrandList}" var="brand">
            <form role="form" method="get" action="/site/catalog" class="btn">
                <input type="submit" value="<c:out value="${brand}"/>" class="btn btn-primary">
                <input type="hidden" name="Brands" value="<c:out value="${brand}"/>">
            </form>
        </c:forEach>
    </div>
    <!-- Бренды-->
    <hr>
</div>

<div class="container">
    <div class="row masonry" data-columns>
        <c:forEach items="${catalogCollectionList}" var="collection">
            <div class="item">
                <div class="thumbnail">
                    <img src="resources/img/col/<c:out value="${collection}.jpg"/> " alt="">

                    <div class="caption">
                        <form role="form" method="get" action="collection">
                            <div id="blok1" class="btn btn-primary">
                                    ${collection}
                            </div>
                            <p align="right">
                                <input type="submit" value="More" class="btn btn-info buyitem">
                                <input type="hidden" name="Brand" value="${catalogBrand}">
                                <input type="hidden" name="Collection" value="${collection}">
                            </p></form>
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