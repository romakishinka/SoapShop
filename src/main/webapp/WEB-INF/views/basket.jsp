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
<div id="content">
    <p>Заказ номер ${basket.orderId}</p>
    <c:forEach items="${basket.getOrderItems()}" var="item">
        <form action="${contextPath}/basket/${item.id}"  method="POST">
            <div class="item_box">
                <h3 class="item_title">${item.product.getProductName()}</h3>
                <p>Стоимость: ${item.getScore()} </p>
                <input type="text" name ="amount" value="${item.amount}">
                    <%--<input type="hidden" name="paramName" value="${product.productId}"/>--%>
                    <%--<input type="hidden" name="param" value="${param}"/>--%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <%--<input type="text" name="amount" value="1"/>--%>
                <input type="submit"  value="Изменить">
                <a href="${contextPath}/basket/${item.id}/delete">Удалить</a>
            </div>
        </form>
    </c:forEach>
    <p>Сумма заказа : ${basket.score}</p>
    <form action="${contextPath}/basket/toorder">
        <button type="submit">Оформить</button>
    </form>
</div>

<!-- FOOTER -->
<footer>
    <small>Netyaga Alexander</small>
</footer>
</body>
</html>
