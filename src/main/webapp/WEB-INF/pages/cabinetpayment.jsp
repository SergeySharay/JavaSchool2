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
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                </div>
                <div class="panel-body">
                    <form role="form" id="pay" action="/site/cabinetorders" method="get">
                        <div class="form-group">
                            <label for="cardNumber" class="privatetable">
                                CARD NUMBER</label>

                            <div class="input-group">
                                <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                       required autofocus pattern="[0-9]{16}"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label for="expityMonth" class="privatetable">
                                        EXPIRY DATE</label>

                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                        <input type="text" class="form-control" id="expityMonth"
                                               pattern="[1-3]{1}[0-9]{1}" placeholder="MM" required/>
                                    </div>
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                        <input type="text" class="form-control" id="expityYear"
                                               pattern="[0-9]{2}" placeholder="YY" required/></div>
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label for="cvCode">
                                        CVV CODE</label>
                                    <input type="password" class="form-control"
                                           pattern="[0-9]{3}" id="cvCode" placeholder="CVV" required/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active">
                    <a href="#">
                        <span class="badge pull-right">
                            <span class="glyphicon glyphicon-usd"></span>
                            ${summer}
                            </span> Final Payment</a>
                </li>
            </ul>
            <br/>
            <button type="submit" form="pay" class="btn btn-success btn-lg btn-block">Pay</button>

        </div>
    </div>
</div>

<script src="resources/js/bootstrap.js"></script>
</body>
</html>