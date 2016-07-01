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
                Product №<c:out value="${productPage.id}"/>
            </div>
            <div class="panel-body">
                <table class="table">
                    <table class="table">
                        <tr>
                            <td>Brand</td>
                            <td><c:out value="${productPage.brand}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Collection</td>
                            <td><c:out value="${productPage.collection}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td><c:out value="${productPage.name}"/>

                            </td>
                        </tr>
                        <tr>
                            <td>Price, Rub.</td>
                            <td><c:out value="${productPage.price}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Length, Cm.</td>
                            <td><c:out value="${productPage.length}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Width, Cm.</td>
                            <td><c:out value="${productPage.width}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Weight, Kg.</td>
                            <td><c:out value="${productPage.weight}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Quantity, Pcs.</td>
                            <td><c:out value="${productPage.quantity}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Color</td>
                            <td><c:out value="${productPage.color}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Picture</td>
                            <td><c:out value="${productPage.picture}"/>
                            </td>
                        </tr>
                    </table>
                </table>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                Product Change
            </div>
            <div class="panel-body">
                <form role="form" method="POST" action="/site/adminproductpage">
                    <div class="form-group">
                        <input type="text" name="brand" class="form-control input-sm"
                               placeholder="Brand" maxlength="80">
                    </div>
                    <div class="form-group">
                        <input type="text" name="collection" class="form-control input-sm"
                               maxlength="80" placeholder="Collcetion">
                    </div>
                    <div class="form-group">
                        <input type="text" name="name" class="form-control input-sm"
                               maxlength="80" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input type="number" name="price" class="form-control input-sm"
                               maxlength="25" placeholder="Price" min="1" max="999999">
                    </div>

                    <div class="form-group">
                        <input type="number" name="length" class="form-control input-sm"
                               maxlength="25" placeholder="Length" min="1" max="1000">
                    </div>
                    <div class="form-group">
                        <input type="number" name="width" class="form-control input-sm"
                               maxlength="25" placeholder="Width" min="1" max="1000">
                    </div>
                    <div class="form-group">
                        <input type="number" name="weight" class="form-control input-sm"
                               maxlength="25" placeholder="Weight" min="1" max="1000">
                    </div>
                    <div class="form-group">
                        <input type="number" name="quantity" class="form-control input-sm"
                               maxlength="25" placeholder="Quantity" min="0" max="5000">
                    </div>
                    <div class="form-group">
                        <input type="text" name="color" class="form-control input-sm"
                               maxlength="80" placeholder="Color">
                    </div>
                    <div class="form-group">
                        <input type="text" name="picture" class="form-control input-sm"
                               maxlength="80" placeholder="Picture">
                    </div>
                    <input type="hidden" name="productId"
                           value="<c:out value="${productPage.id}"/>">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Save" class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
</div>

<script src="resources/js/bootstrap.js"></script>

</body>
</html>
