<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Корзина</title>
    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

</head>
<body>
<jsp:include page="mainHeader.jsp"/>
<div class="container">
    <h2>Заказ номер ${basket.orderId}</h2>
    <c:forEach items="${basket.getOrderItems()}" var="item">
        <form action="${contextPath}/basket/${item.id}"  method="POST">
            <div class="item_box" style="float:none; height: auto">
                <h3 class="item_title">${item.product.getProductName()}</h3>
                <p>Стоимость: ${item.getScore()} </p>
                <div>
                    <p>Количество:</p> <input type="text" class="input_field" name ="amount" value="${item.amount}">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="button-ss" value="Изменить">
                <a class = "link-ss" href="${contextPath}/basket/${item.id}/delete">Удалить</a>
            </div>
        </form>
    </c:forEach>
    <h3>Сумма заказа : ${basket.score}</h3>
    <form action="${contextPath}/basket/toorder">
        <input type="submit" class="button-ss" value="Оформить"/>
    </form>
</div>

<!-- FOOTER -->
<footer>
    <small>Netyaga Alexander</small>
</footer>
</body>
</html>
