<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 21.05.2017
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Главная страница</title>

    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<jsp:include page="mainHeader.jsp"/>
<div class="container">
    <div class="panel">
        <div class="container">
            <div class="row">
                <a href="${contextPath}/products" class="btn" style="margin-left:40%; padding-left: 40px;padding-right: 40px; ">Новинки</a>
            </div>
        </div>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Ландыш"</h3>
        <div class="gallery"><img src="/resources/img/photo5.jpeg"></div>
        <p class="price">Цена: <span class="item_price">300</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Ваниль"</h3>
        <div class="gallery"><img src="/resources/img/photo8.jpeg"></div>
        <p class="price">Цена: <span class="item_price">350</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Миша"</h3>
        <div class="gallery"><img src="/resources/img/photo7.jpeg"></div>
        <p class="price">Цена: <span class="item_price">300</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
</div>
<div class="container">
    <div class="panel">
        <div class="container">
            <div class="row">
                <a href="${contextPath}/products" class="btn" style="margin-left:40%; padding-left: 40px;padding-right: 40px; ">Популярное</a>
            </div>
        </div>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Роза"</h3>
        <div class="gallery"><img src="/resources/img/photo6.jpeg"></div>
        <p class="price">Цена: <span class="item_price">300</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Виноград"</h3>
        <div class="gallery"><img src="/resources/img/photo2.jpeg"></div>
        <p class="price">Цена: <span class="item_price">340</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Звезда"</h3>
        <div class="gallery"><img src="/resources/img/photo9.jpeg"></div>
        <p class="price">Цена: <span class="item_price">290</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
</div>
<div class="container">
    <div class="panel">
        <div class="container">
            <div class="row">
                <a href="${contextPath}/products" class="btn" style="margin-left:40%; padding-left: 40px;padding-right: 40px; ">Акции</a>
            </div>
        </div>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Шар" (синий)</h3>
        <div class="gallery"><img src="/resources/img/photo12.jpeg"></div>
        <p class="price">Цена: <span class="item_price">250</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Шар" (красный)</h3>
        <div class="gallery"><img src="/resources/img/photo11.jpeg"></div>
        <p class="price">Цена: <span class="item_price">250</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
    <div class="item_box">
        <h3 class="item_title">Мыло "Ваниль"</h3>
        <div class="gallery"><img src="/resources/img/photo8.jpeg"></div>
        <p class="price">Цена: <span class="item_price">300</span>P</p>
        <form action="${contextPath}/products" method="GET">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" class="button-ss" value="Добавить">
        </form>
    </div>
</div>
<!-- FOOTER -->
<footer>
    <small>Netyaga Alexander</small>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>