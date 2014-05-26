<#import "layout.ftl" as layout/>
<@layout.layout>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="width: 600px;margin: 0 auto;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        <li data-target="#carousel-example-generic" data-slide-to="4"></li>
        <li data-target="#carousel-example-generic" data-slide-to="5"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="/images/2.png" alt="...">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="/images/3.png" alt="...">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="/images/4.png" alt="...">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="/images/5.png" alt="...">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="/images/6.png" alt="...">
            <div class="carousel-caption">
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>
</@layout.layout>