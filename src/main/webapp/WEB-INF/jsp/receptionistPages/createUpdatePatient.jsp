<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.academy.hospital.model.entity.Gender" %>
<html>
<head>

    <title>Create new patient </title>
    <link rel="stylesheet" href="/css/simpleStyle.css">
</head>
<body>

<div class="container">
    <h1>пациент</h1>

    <c:url value="/receptionist/createUpdatePatient" var="createUpdatePatientAction"/>
    <sf:form method="post" action="${createUpdatePatientAction}" modelAttribute="patient" class="form">
        <div class="form-row">
            <sf:label path="surname">Фамилия:</sf:label>
            <sf:input path="surname" required="required"/>
        </div>

        <div class="form-row">
            <sf:label path="name">Имя:</sf:label>
            <sf:input path="name" required="required"/>
        </div>

        <div class="form-row">
            <sf:label path="patronymic">Отчество:</sf:label>
            <sf:input path="patronymic"/>
        </div>

        <div class="form-row">
            <sf:label path="gender">Пол:</sf:label>
            <div class="radio-group">
                <sf:radiobutton path="gender" value="${Gender.MALE}" name="gender" checked="checked"/>
                <sf:label path="gender" cssClass="light">Мужской</sf:label>
            </div>
            <div class="radio-group">
                <sf:radiobutton path="gender" value="${Gender.FEMALE}" name="gender"/>
                <sf:label path="gender" cssClass="light">Женский</sf:label>
            </div>
        </div>

        <div class="form-row">
            <sf:label path="dob">Дата рождения:</sf:label>
            <sf:input type="date" path="dob" required="required"/>
        </div>

        <div class="form-row">
            <sf:label path="passport">Паспортный номер:</sf:label>
            <sf:input path="passport"/>
        </div>

        <div class="form-row">
            <sf:label path="phone">Телефон:</sf:label>
            <sf:input path="phone"/>
        </div>

        <sf:hidden path="id"/>

        <div class="form-row">
            <button type="submit" class="submit-button">OK</button>
        </div>
    </sf:form>

    <div class="menu">
        <a href="<c:url value="/receptionist/mainPage"/>">Назад на главное меню</a>
    </div>
</div>
</body>
</html>