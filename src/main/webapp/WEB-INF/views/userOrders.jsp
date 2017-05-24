<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Мои заказы</title>
    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="mainHeader.jsp"/>
<c:forEach items="${orders}" var="order">
    <div class="container">
        <div class="order_box">
            <h4 class="order_title">Заказ номер ${order.orderId}</h4>
            <table class="order_table">
                <tr>
                    <td>Наименование продукта</td>
                    <td>Количество</td>
                    <td>Стоимость</td>
                </tr>
                <c:forEach items="${order.getOrderItems()}" var="item">
                    <tr>
                        <td>${item.product.getProductName()}</td>
                        <td>${item.amount}</td>
                        <td>${item.getScore()}</td>
                    </tr>
                </c:forEach>
            </table>
            <h4 class="order_score">Cумма заказа :  ${order.getScore()}</h4>
        </div>
    </div>
</c:forEach>
</body>
</html>
