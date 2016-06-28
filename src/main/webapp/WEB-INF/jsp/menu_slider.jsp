<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<div id="carousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-target="#carousel" data-slide-to="0"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
        <li data-target="#carousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="resources/img/pict1.jpg" alt="">

            <div class="carousel-caption">
                <h3>First slide</h3>

                <p>Description 1</p>
            </div>
        </div>
        <div class="item">
            <img src="resources/img/pict2.jpg" alt="">

            <div class="carousel-caption">
                <h3>Second slide</h3>

                <p>Description 2</p>
            </div>
        </div>
        <div class="item">
            <img src="resources/img/pict3.jpg" alt="">

            <div class="carousel-caption">
                <h3>Third slide</h3>

                <p>Description 3</p>
            </div>
        </div>
    </div>
    <a href="#carousel" class="left carousel-control" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a href="#carousel" class="right carousel-control" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>