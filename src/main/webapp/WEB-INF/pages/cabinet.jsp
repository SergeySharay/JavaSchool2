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

<div class="container" id="cabinetpage">
    <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-0 col-lg-6 col-lg-offset-0">
        <div class="panel panel-default">
            <div class="panel-body privatetable">
                <p>Personal</p>
            </div>
            <table class="table">
                <tr>
                    <td>First Name</td>
                    <td><c:out value="${User.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><c:out value="${User.surname}"/>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><c:out value="${User.email}"/>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><c:out value="${User.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>Birthday</td>
                    <td>
                        ${User.birthday == null ? "Отсутсвует" : format.format(User.birthday)}
                    </td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>${User.permission == 1 ? "Сотрудник" : "Покупатель"}
                    </td>
                </tr>
            </table>
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
                    <td><c:out value="${clientAdress.country}"/></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><c:out value="${clientAdress.city}"/></td>
                </tr>
                <tr>
                    <td>Street</td>
                    <td><c:out value="${clientAdress.street}"/></td>
                </tr>
                <tr>
                    <td>House</td>
                    <td><c:out value="${clientAdress.house}"/></td>
                </tr>
                <tr>
                    <td>Apartment</td>
                    <td><c:out value="${clientAdress.flat}"/></td>
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
