<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <title>Локация</title>
    <!-- Bootstrap -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="mainHeader.jsp"/>
<div class="container">

    <form:form method="POST" modelAttribute="location" class="form-signin">
        <h2 class="form-signin-heading">Введите данные о вашем местоположении</h2>
        <div class="form-group">
            <form:input type="text" path="contry" class="form-control" placeholder="Страна"
                        autofocus="true"></form:input>
        </div>

        <div class="form-group">
            <form:input type="text" path="city" class="form-control" placeholder="Город"></form:input>
        </div>

        <div class="form-group">
            <form:input type="text" path="street" class="form-control"
                        placeholder="Улица"></form:input>
        </div>
        <div class="form-group">
            <form:input type="text" path="houseNumber" class="form-control"
                        placeholder="Номер дома"></form:input>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">СОХРАНИТЬ</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
