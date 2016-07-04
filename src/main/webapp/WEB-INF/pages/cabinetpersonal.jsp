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
            <div class="panel-heading">
                <h3 class="panel-title">Personal</h3>
            </div>
            <c:if test="${emailError=='true'}">
                <div class="privatetable"><p align="center">Email already exist</p></div>
            </c:if>
            <div class="panel-body privatetable">
                <form role="form" method="POST" action="/site/cabinetpersonal">
                    <div class="form-group">
                        <input type="text" name="firstName" id="firstName" class="form-control input-sm"
                               maxlength="50" placeholder="First Name" pattern="^[A-Za-zА-Яа-яЁё\s\-]+$">
                    </div>
                    <div class="form-group">
                        <input type="text" name="lastName" id="lastName" class="form-control input-sm"
                               maxlength="50" placeholder="Last Name" pattern="^[A-Za-zА-Яа-яЁё\s\-]+$">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" id="email" class="form-control input-sm"
                               maxlength="60" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" name="pass" id="pass" class="form-control input-sm"
                               maxlength="30" placeholder="Password" pattern="^[A-Za-z\0-9]+$">
                    </div>
                    <div class="form-group">
                        <input type="date" name="date" id="date" class="form-control input-sm"
                               placeholder="Birthday DD.MM.YYYY">
                    </div>
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
