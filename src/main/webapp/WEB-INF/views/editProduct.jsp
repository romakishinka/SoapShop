<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 23.05.2017
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование продукта</title>
</head>
<body>
<jsp:include page="mainHeaderAdmin.jsp"/>
<form action="${contextPath}/admin/products/${product.productId}" method="post">
    <div class="create-prod">
        <p>Создание продукта</p>
        <div>
            <input type="text" name="productName" value="${product.productName}"/>
        </div>
        <div>
            <input type="text" name="price" value="${product.price}"/>
        </div>
        <div>
            <input type="text" name="description"  value="${product.description}"/>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
    <button type ="submit">Сохранить</button>
</form>
</body>
</html>
