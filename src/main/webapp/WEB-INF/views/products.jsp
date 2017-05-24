<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<html>
<head>
    <title>Товары</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body>
<!-- HEADER-NAV -->
<jsp:include page="mainHeader.jsp"/>

<div class="container">
    <c:forEach items="${products}" var="product">

        <div class="item_box">
            <h3 class="item_title">${product.productName}</h3>
            <div class="gallery"><img src="${product.photo}"></div>
            <p class="price">Цена: <span class="item_price">${product.price}</span>P</p>
            <form action="${contextPath}/products/addToBasket?code=${product.productId}" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="button-ss" value="Добавить">
            </form>
        </div>

    </c:forEach>
</div>

<!-- FOOTER -->
<footer>
    <small>Netyaga Alexander</small>
</footer>
</body>
</html>
