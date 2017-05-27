<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Местоположение пользователя</title>
    <!-- Bootstrap -->
    <link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="mainHeaderAdmin.jsp"/>
<div class="container">
    <h4 class="order_title">Местоположение пользователя: ${location.getUser().getUsername()} </h4>
    <table class="order-table">
        <tr>
            <td>Страна</td>
            <td>Город</td>
            <td>Улица</td>
            <td>дом</td>
        </tr>
            <tr>
                <td>${location.getContry()}</td>
                <td>${location.getCity()}</td>
                <td>${location.getStreet()}</td>
                <td>${location.getHouseNumber()}</td>
            </tr>
    </table>
</div>
</body>
</html>
