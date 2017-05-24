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
        <form action="${contextPath}/products?code=${product.productId}"
              method="POST">
            <div class="item_box">
                <h3 class="item_title">${product.productName}</h3>
                <div class="gallery"><img src="${product.photo}"></div>
                <p class ="price">Цена: <span class="item_price">${product.price}</span>P</p>
                    <%--<input type="hidden" name="paramName" value="${product.productId}"/>--%>
                    <%--<input type="hidden" name="param" value="${param}"/>--%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <%--<input type="text" name="amount" value="1"/>--%>
                <input type="submit"  class="button-ss" value="Добавить">

            </div>
        </form>
    </c:forEach>
</div>

<!-- FOOTER -->
<footer>
    <small>Netyaga Alexander</small>
</footer>
</body>
</html>
