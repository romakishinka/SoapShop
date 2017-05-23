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
    <form action="${contextPath}/admin/products/${product.productId}" method="GET">
        <div class="item_box">
            <h3 class="item_title">${product.productName}</h3>
            <img src="${product.photo}">
            <p>Цена: <span class="item_price">${product.price}</span>$</p>
                <%--<input type="hidden" name="paramName" value="${product.productId}"/>--%>
                <%--<input type="hidden" name="param" value="${param}"/>--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <%--<input type="text" name="amount" value="1"/>--%>
            <input type="submit" value="Изменить">
            <a href="${contextPath}/admin/products/${product.productId}/delete">Удалить</a>
        </div>
    </form>
</c:forEach>
<form action="${contextPath}/admin/products/new" method="GET">
    <button type ="submit">создать продукт</button>
</form>

</body>
</html>
