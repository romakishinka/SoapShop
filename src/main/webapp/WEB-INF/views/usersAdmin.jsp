<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 24.05.2017
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Пользователь сайта</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<jsp:include page="mainHeaderAdmin.jsp"/>
<c:forEach items="${users}" var="user">
    <div class="container">
        <h3>Заказы пользователя <a href="/admin/location/${user.getUsername()}">${user.getUsername()}</a></h3>
        <c:forEach items="${user.orders}" var="order">
            <div class="order_box">
                <h4 class="order_title">Заказ номер ${order.getOrderId()} (статус:
                    <c:if test="${order.status == 1}">
                        в корзине
                    </c:if>
                    <c:if test="${order.status == 2}">
                        оформлен
                    </c:if>
                    <c:if test="${order.status == 3}">
                        отправлен
                    </c:if>
                    <c:if test="${order.status == 4}">
                        плучен
                    </c:if>
                    )
                </h4>
                <table class="order-table">
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
                <h4 class="order_score" >Cумма заказа : ${order.getScore()}</h4>
                <form action="${contextPath}/admin/users/changeStatus/${order.getOrderId()}">
                    <input type="submit" class="button-ss" value ="Подтвердить отправку"/>
                </form>
                <form action="${contextPath}/admin/users/delete/${order.getOrderId()}">
                    <input type="submit" class="button-ss" value ="Удалить"/>
                </form>
            </div>
        </c:forEach>
        <form action="${contextPath}/admin/users/${user.getId()}">
            <input type="submit" class="button-ss" value ="Удалить все заказы"/>
        </form>
    </div>
</c:forEach>
</body>
</html>
