<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-inverse container">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu2">
                <span class="sr-only">Open</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu2">
            <ul class="nav navbar-nav">
                <li><a href="/site/cabinet"><i class="glyphicon glyphicon-refresh"></i> Cabinet</a></li>
                <li><a href="/site/cabinetorders">Orders</a></li>
                <li><a href="/site/cabinetpersonal">Personal</a></li>
                <li><a href="/site/cabinetaddress">Address</a></li>
                <li><a href="/site/bucket">Cart</a></li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/site/admin">Administration</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</div>

