<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="navbar_menu">
    <div class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                    <span class="sr-only">Open</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="responsive-menu">
                <ul class="nav navbar-nav">
                    <li><a href="/site/"><i class="glyphicon glyphicon-home"></i></a></li>
                    <li><a href="/site/about">About Us</a></li>
                    <li><a href="/site/catalog">Catalog</a></li>
                    <li><a href="/site/contacts">Contacts</a></li>
                    <li><a href="/site/delivery">Delivery</a></li>
                    <li><a href="/site/pay">Payment</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:authorize access="!isAuthenticated()">
                        <li><a href="/site/login">Login</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                    <li><a href="/site/catalog"><i class="glyphicon glyphicon-user"></i>
                        <c:out value="${pageContext.request.userPrincipal.name}"/></a></li>
                    <li>
                        <form action="/site/logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit" value="Logout" class="btn-logout"></form>
                        </sec:authorize>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="col-xs-12">
        <div id="bucket"><a href="bucket.jsp"><img src="resources/img/bucket.png"></a></div>
    </div>
</div>