<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <title>Patient</title>
    <link rel="stylesheet" href="/css/simpleStyle.css">
</head>

<h1>Пациент</h1>

    <div class="form">
        <div class="form-row">
            <label>Фамилия:</label> ${patient.surname}
        </div>
        <div class="form-row">
            <label>Имя:</label> ${patient.name}
        </div>
        <div class="form-row">
            <label>Отчество:</label> ${patient.patronymic}
        </div>
        <div class="form-row">
            <label>Дата рождения:</label> ${patient.dob}
        </div>
        <div class="form-row">
            <label>Пол:</label> ${patient.gender}
        </div>
        <div class="form-row">
            <label>Телефон:</label> ${patient.phone}
        </div>
        <div class="form-row">
            <label>Паспортный номер:</label> ${patient.passport}
        </div>
    </div>

    <c:url value="/receptionist/showCreateUpdatePatient" var="updatePatientAction"/>
    <sf:form method="post" action="${updatePatientAction}" modelAttribute="patient">
        <sf:hidden path="id"/>
        <sf:hidden path="surname"/>
        <sf:hidden path="name"/>
        <sf:hidden path="patronymic"/>
        <sf:hidden path="gender"/>
        <sf:hidden path="dob"/>
        <sf:hidden path="passport"/>
        <sf:hidden path="phone"/>
        <div class="form-row">
            <button type="submit" class="submit-button">Изменить данные</button>
        </div>
    </sf:form>

    <div class="menu">
        <a href="<c:url value="/receptionist/createCard?id=${patient.id}"/>" class="menu-button"> создать карту </a>
        <a href="<c:url value="/receptionist/mainPage"/>"> Назад на главное меню </a>
    </div>

</body>
</html>