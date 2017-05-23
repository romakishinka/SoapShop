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
    <div id="order-item">
        <p>Заказ номер ${order.orderId}</p>
        <table class="order-table">
            <tr>
                <td>Наименование продукта</td>
                <td>Количество</td>
                <td>Стоимость</td>
            </tr>
        <c:forEach items="${order.getOrderItems()}" var="item">
            <tr>

            <%--<c:set var="price" value="${item.amount}*${item.product.getPrice()}"/>--%>
                <%--<div class="item_box">--%>
                    <%--<h3 class="item_title">${item.product.getProductName()}</h3>--%>
                    <%--<p>Стоимость: <c:out value="${price}"/></p>--%>
                    <%--<input type="text" name="amount" value="${item.amount}">--%>
                        <%--&lt;%&ndash;<input type="hidden" name="paramName" value="${product.productId}"/>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<input type="hidden" name="param" value="${param}"/>&ndash;%&gt;--%>
                    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                        <%--&lt;%&ndash;<input type="text" name="amount" value="1"/>&ndash;%&gt;--%>
                    <%--<input type="submit" value="Изменить">--%>
                    <%--<a href="${contextPath}/basket/${item.id}/delete">Удалить</a>--%>
                <%--</div>--%>
                <td>${item.product.getProductName()}</td>
                <td>${item.amount}</td>
                <td>${item.getScore()}</td>
            </tr>
        </c:forEach>
        </table>
        <p>Cумма заказа :  ${order.getScore()}</p>
    </div>
</c:forEach>
</body>
</html>
