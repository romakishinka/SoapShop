<%--используемые бибилиотеки тегов--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--определяю переменную contextPath--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Корзина</title>
    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

</head>
<body>
<%--Импортирую навигационную панель--%>
<jsp:include page="mainHeader.jsp"/>
<div class="container">
    <h2>Заказ номер ${basket.orderId}</h2>
    <%--для каждого элемента вывожу информацию о нём--%>
    <c:forEach items="${basket.getOrderItems()}" var="item">
        <%--каждая форма элемента заказа оснащена полем input типа submit, при нажатии на которое--%>
        <%--на сервер отправляет запрос с содержимым свойства формы action--%>
        <form action="${contextPath}/basket/${item.id}"  method="POST">
            <div class="item_box" style="float:none; height: auto">
                <h3 class="item_title">${item.product.getProductName()}</h3>
                <p>Стоимость: ${item.getScore()} </p>
                <div>
                    <p>Количество:</p> <input type="text" class="input_field" name ="amount" value="${item.amount}">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <%--кнопка submit, вызывающая срабатывание action формы--%>
                <input type="submit" class="button-ss" value="Изменить">
                <%--ссылка запроса удаления элемента--%>
                <a class = "link-ss" href="${contextPath}/basket/${item.id}/delete">Удалить</a>
            </div>
        </form>
    </c:forEach>
    <h3>Сумма заказа : ${basket.score}</h3>
    <%--форма с action - оформления заказа (перехода заказа в другое состояние)--%>
    <form action="${contextPath}/basket/toorder">
        <input type="submit" class="button-ss" value="Оформить"/>
    </form>
</div>

<!-- FOOTER -->
<footer>
    <small>Kishinka Roman</small>
</footer>
</body>
</html>
