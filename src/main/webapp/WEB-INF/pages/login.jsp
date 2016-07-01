<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                        <div align="center">Invalid Login or Password.</div>
                    </c:if>
                </div>
                <div class="panel-body">
                    <form role="form" method="POST" action="/site/login">
                        <div class="form-group">
                            <input type="email" name="username" id="email" class="form-control input-sm"
                                   placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-sm"
                                   placeholder="Password" required>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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