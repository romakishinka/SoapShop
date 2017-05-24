<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Продукты: создать/изменить</title>
    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="mainHeaderAdmin.jsp"/>
<c:forEach items="${products}" var="product">
    <div class="container">
        <form action="${contextPath}/admin/products/${product.productId}" method="GET">
            <div class="item_box" style=" float:left ">
                <h3 class="item_title">${product.productName}</h3>
                <div class="gallery"><img src="${product.photo}"></div>
                <p class="price">Цена: <span class="item_price">${product.price}</span>p</p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="button-ss" value="Изменить">
                <a href="${contextPath}/admin/products/${product.productId}/delete">Удалить</a>
            </div>
        </form>
    </div>
</c:forEach>
<form action="${contextPath}/admin/products/new" method="GET">
    <input type="submit" value="создать продукт"/>
</form>

</body>
</html>
