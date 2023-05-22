<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <title>Success Card</title>
    <link rel="stylesheet" href="/css/simpleStyle.css">

</head>
<body>

<h1>карта создана</h1>

<div class="container">
    <div class="form">
        <div class="form-row">
            <label>Дата поступления:</label> ${card.dateOfAdmission}
        </div>
        <div class="form-row">
            <label>Фамилия:</label> ${card.patient.surname}
        </div>
        <div class="form-row">
            <label>Имя:</label> ${card.patient.name}
        </div>
        <div class="form-row">
            <label>Отчество:</label> ${card.patient.patronymic}
        </div>
    </div>



    <div class="menu">
        <a href="<c:url value="/receptionist/mainPage"/>"> Назад на главное меню </a>
    </div>
</div>
</body>
</html>