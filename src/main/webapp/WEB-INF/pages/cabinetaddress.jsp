<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Cabinet</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<%@ include file="/WEB-INF/jsp/cabinetbar.jsp" %>
<div class="container">
    <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-0 col-lg-6 col-lg-offset-0">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Address</h3>
            </div>
            <div class="panel-body privatetable">
                <form role="form" method="POST" action="/cabinetaddress">
                    <div class="form-group">
                        <input type="text" name="country" id="country" class="form-control input-sm"
                               placeholder="Country" maxlength="40" pattern="^[A-Za-zА-Яа-яЁё\s\-]+$">
                    </div>
                    <div class="form-group">
                        <input type="text" name="city" id="city" class="form-control input-sm"
                               maxlength="40" placeholder="City" pattern="^[A-Za-zА-Яа-яЁё\s\-]+$">
                    </div>
                    <div class="form-group">
                        <input type="text" name="street" id="street" class="form-control input-sm"
                               maxlength="40" placeholder="Street" pattern="^[A-Za-zА-Яа-яЁё\s\-\0-9]+$">
                    </div>
                    <div class="form-group">
                        <input type="text" name="house" id="house" class="form-control input-sm"
                               maxlength="25" placeholder="House" pattern="^[A-Za-zА-Яа-яЁё\s\-\0-9]+$">
                    </div>
                    <div class="form-group">
                        <input type="text" name="flat" id="flat" class="form-control input-sm"
                               maxlength="25" placeholder="Apartment" pattern="^[A-Za-zА-Яа-яЁё\s\-\0-9]+$">
                    </div>
                    <div class="form-group">
                        <input type="number" name="zipcode" id="zipcode" class="form-control input-sm"
                               placeholder="Zipcode" size="6" min="100000" max="999999">
                    </div>
                    <input type="submit" value="Save" class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-0 col-lg-6 col-lg-offset-0">
        <div class="panel panel-default">
            <div class="panel-body privatetable">
                <p>Address</p>
            </div>
            <table class="table">
                <tr>
                    <td>Country</td>
                    <td>
                        <c:out value="${clientAdress.country}"/>
                    </td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><c:out value="${clientAdress.city}"/>
                    </td>
                </tr>
                <tr>
                    <td>Street</td>
                    <td><c:out value="${clientAdress.street}"/>
                    </td>
                </tr>
                <tr>
                    <td>House</td>
                    <td><c:out value="${clientAdress.house}"/>
                    </td>
                </tr>
                <tr>
                    <td>Apartment</td>
                    <td><c:out value="${clientAdress.flat}"/>
                    </td>
                </tr>
                <tr>
                    <td>Zip Code</td>
                    <td><c:out value="${clientAdress.zipcode}"/></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
