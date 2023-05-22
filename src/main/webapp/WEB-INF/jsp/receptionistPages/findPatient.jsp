<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Found Patients </title>
    <link rel="stylesheet" href="/css/simpleStyle.css">

</head>
<body>
<div class="container">
    <h1>Найденные пациенты</h1>

    <table class="table">
        <thead>
        <tr>
            <th>ФИО</th>
            <th>Дата рождения</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>
                    <a href="<c:url value='/receptionist/patient?id=${patient.id}'/>">
                            ${patient.surname} ${patient.name} ${patient.patronymic}
                    </a>
                </td>
                <td>${patient.dob}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="menu">
        <a href="<c:url value='/receptionist/showCreateUpdatePatient'/>" class="menu-button">Зарегистрировать нового пациента</a>
        <a href="<c:url value='/receptionist/mainPage'/>" class="menu-link">Назад на главное меню</a>
    </div>
</div>
</body>
</html>