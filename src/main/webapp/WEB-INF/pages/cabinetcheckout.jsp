<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Checkout</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container">
    <div class="row masonry2" data-columns>
        <div class="item">
            <div class="panel panel-default">
                <div class="panel-heading"><p>Order Details</p></div>
                <div class="panel-body privatetable">
                    <p>Order Price, Rub.: ${sum}</p>

                    <p>Items In Cart, Pcs: ${Cart.size()}</p>

                    <form action="/site/bucket">
                        <button type="submit" value="" class="btn btn-primary">Change</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="panel panel-default">
                <div class="panel-heading"><p>Infromation</p></div>
                <div class="panel-body privatetable">
                    <form id="nextorder" action="/site/cabinetgetorder" method="Post">
                        <fieldset class="fieldset">
                            <div class="control-group">
                                <label class="control-label">Payment</label>

                                <div class="controls" id="pay">
                                    <label class="radio">
                                        <input type="radio" name="Rad1" id="optionsRadios1" value="Наличные" checked="">
                                        Cash
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="Rad1" id="optionsRadios2" value="Безналичный расчет">
                                        Cashless
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="Rad1" id="optionsRadios3" value="Оплата картой">
                                        Cards
                                    </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Delivery</label>

                                <div class="controls" id="delivery">
                                    <label class="radio">
                                        <input type="radio" name="Rad2" id="optionsRadios4" value="Самовывоз"
                                               checked="">
                                        Pickup by the customer
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="Rad2" id="optionsRadios5" value="Доставка">
                                        Delivery
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="Rad2" id="optionsRadios6" value="Перемещение">
                                        Moving
                                    </label>
                                </div>
                            </div>
                            <hr>
                            <div class="control-group">
                                <label class="control-label" id="inputtext" for="textarea">Comments</label>

                                <div class="controls">
                                    <textarea class="input" name="Rad3" id="textarea" rows="3"></textarea>
                                </div>
                            </div>
                        </fieldset>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="panel panel-default">
                <div class="panel-heading"><p>Address</p></div>
                <div class="panel-body privatetable">
                    <table class="table">
                        <tr>
                            <td>Country</td>
                            <td>
                                <c:out value="${clientAddress.country}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td><c:out value="${clientAddress.city}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Street</td>
                            <td><c:out value="${clientAddress.street}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>House</td>
                            <td><c:out value="${clientAddress.house}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Appartment</td>
                            <td><c:out value="${clientAddress.flat}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Zip Code</td>
                            <td><c:out value="${clientAddress.zipcode}"/></td>
                        </tr>
                    </table>
                    <form action="/site/cabinetaddress">
                        <button type="submit" value="" class="btn btn-primary">Change</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="panel panel-default">
                <div class="panel-heading"><p>Checkout</p></div>
                <div class="panel-body privatetable">

                    <button type="submit" form="nextorder" class="btn btn-primary">Confirm</button>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/salvattore.min.js"></script>
</body>
</html>
