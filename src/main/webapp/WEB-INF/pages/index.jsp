<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <title>Cats</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container">
    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12" id="left_menu">
        <%@ include file="/WEB-INF/jsp/menu_left.jsp" %>
    </div>
    <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
        <%@ include file="/WEB-INF/jsp/menu_slider.jsp" %>
    </div>
</div>
<div class="container">
    <hr>
    <div class="row">
        <h1 align="center">Welcome!</h1>
    </div>
    <hr>
</div>
<div class="container">
    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <p align="justify">
            Poop on grasses steal the warm chair right after you get up so sit in window and stare ooo, a bird!
            yum or ignore the squirrels, you'll never catch them anyway but climb a tree,
            wait for a fireman jump to fireman then scratch his face sit on the laptop or claw drapes.
            The dog smells bad. Knock dish off table head butt cant eat out of my own dish eat from dog's
            food scream at teh bath but chase ball of string flop over. Give attitude.
            Howl uncontrollably for no reason climb leg.
            Roll on the floor purring your whiskers off all of a sudden cat goes crazy,
            sit on human sleep nap hunt by meowing loudly at 5am next to human slave food dispenser peer out window,
            chatter at birds, lure them to mouth hunt anything that moves.
        </p>
    </div>
    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12"><p align="justify">
        Eat prawns daintily with a claw then lick paws clean wash down prawns with a lap of carnation milk
        then retire to the warmest spot on the couch to claw at the fabric before taking a catnap attack feet,
        and scratch the box human is washing you why halp oh the horror flee scratch hiss bite.
        Claw drapes chase after silly colored fish toys around the house.
        Stare at ceiling chew foot please stop looking at your phone and pet me for intently stare at the same spot.
        Under the bed eat prawns daintily with a claw then lick paws clean wash down prawns with a lap of carnation milk
        then retire to the warmest spot on the couch to claw at the fabric before taking a catnap.
        Leave fur on owners clothes. Hide head under blanket so no one can see chase dog.
    </p>
    </div>
</div>
<div class="container">
    <%@ include file="/WEB-INF/jsp/footer.jsp" %>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script>
    $(function () {
        $('[data-toogle="popover"]').popover();
    })
</script>

</body>
</html>
