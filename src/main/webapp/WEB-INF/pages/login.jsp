<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</head>

<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-10 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4 col-xs-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">If you have an account, please log in.</h3>
                </div>
                <div class="panel-body">
                    <form role="form" method="POST" action="/login">
                        <c:if test="${checkac=='false'}">
                            <div class="privatetable"><p align="center">Неправильно введен Логин или Пароль.</p></div>
                        </c:if>
                        <div class="form-group">
                            <input type="email" name="j_username" id="email" class="form-control input-sm"
                                   placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <input type="password" name="j_password" id="password" class="form-control input-sm"
                                   placeholder="Password" required>
                        </div>
                        <input type="submit" value="Login" class="btn btn-info btn-block">
                    </form>
                </div>
            </div>
            <p align="center"><a href="/site/reg">CREATE AN ACCOUNT</a></p>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>