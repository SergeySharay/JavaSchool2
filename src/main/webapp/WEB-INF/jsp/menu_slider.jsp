<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>

<div id="carousel" class="carousel slide">
    <!-- индикаторый слайдов-->
    <ol class="carousel-indicators">
        <li class="active" data-target="#carousel" data-slide-to="0"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
        <li data-target="#carousel" data-slide-to="2"></li>
    </ol>
    <!-- слайды -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="resources/img/pict1.jpg" alt="">

            <div class="carousel-caption">
                <h3>Первый слайд</h3>

                <p>Описание 1 слайда</p>
            </div>
        </div>
        <div class="item">
            <img src="resources/img/pict2.jpg" alt="">

            <div class="carousel-caption">
                <h3>Второй слайд</h3>

                <p>Описание 2 слайда</p>
            </div>
        </div>
        <div class="item">
            <img src="resources/img/pict3.jpg" alt="">

            <div class="carousel-caption">
                <h3>Третий слайд</h3>

                <p>Описание 3 слайда</p>
            </div>
        </div>
    </div>

    <!-- стрелка переключени¤ слайдов -->
    <a href="#carousel" class="left carousel-control" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a href="#carousel" class="right carousel-control" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>