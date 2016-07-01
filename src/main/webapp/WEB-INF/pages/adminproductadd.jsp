<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="windows-1251" %>
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
                Create new product.
            </div>
            <div class="panel-body">
                <form role="form" method="post" action="/site/adminproductadd">
                    <div class="form-group">
                        <input type="text" name="brand" class="form-control input-sm"
                               placeholder="Brand" maxlength="80" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="collection" class="form-control input-sm"
                               maxlength="80" placeholder="Collection" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="name" class="form-control input-sm"
                               maxlength="80" placeholder="Name" required>
                    </div>
                    <div class="form-group">
                        <input type="number" name="price" class="form-control input-sm"
                               maxlength="25" placeholder="Price" min="1" max="999999" required>
                    </div>

                    <div class="form-group">
                        <input type="number" name="length" class="form-control input-sm"
                               maxlength="25" placeholder="Length" min="1" max="1000" required>
                    </div>
                    <div class="form-group">
                        <input type="number" name="width" class="form-control input-sm"
                               maxlength="25" placeholder="Width" min="1" max="1000" required>
                    </div>
                    <div class="form-group">
                        <input type="number" name="weight" class="form-control input-sm"
                               maxlength="25" placeholder="Weight" min="1" max="1000" required>
                    </div>
                    <div class="form-group">
                        <input type="number" name="quantity" class="form-control input-sm"
                               maxlength="25" placeholder="Quantity" min="0" max="5000" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="color" class="form-control input-sm"
                               maxlength="80" placeholder="Color" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="picture" class="form-control input-sm"
                               maxlength="80" placeholder="Picture">
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Add" class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
