<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 21.05.2017
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div id="wrapper">
    <header id="header">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="container">
            <div class="h-panel clearfix">
                <nav class="h-nav h-nav-center">
                    <a href="${contextPath}/main">Главная</a>
                    <a href="#">Поддержка</a>
                    <a href="#">Сотрудничество</a>
                    <a href="${contextPath}/about">О нас</a>
                    <a href="${contextPath}/admin/products">Продукты: создать/изменить</a>
                    <a href="${contextPath}/about/users">Пользователи</a>
                </nav>
                <nav class="h-nav pull-right">
                    <a href="${contextPath}/userOrders">${pageContext.request.userPrincipal.name}</a>
                    <a onclick="document.forms['logoutForm'].submit()">Выйти</a>
                </nav>
            </div>
        </div>
    </header>
    <div class="panel">
        <div class="container">
            <div class="row">
                <a href="${contextPath}/products" class="btn">Каталог товаров</a>
                <a href="${contextPath}/basket" class="btn btn-basket pull-right"> Корзина</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
