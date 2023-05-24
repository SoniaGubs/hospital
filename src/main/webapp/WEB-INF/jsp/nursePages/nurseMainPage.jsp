<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <title>Nurse's main page</title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>

<div class="container">
    <h1> Nurse's main page </h1>

    <h2>Список пациентов:</h2>

    <table class="table">
        <tr>
            <th>ФИО</th>
            <th>Дата поступления:</th>
            <th>Лечащий врач:</th>
        </tr>

        <c:forEach items="${sicks}" var="card">
            <tr>
                <td>
                    <a href="<c:url value="/nurse/card?id=${card.id}"/>">${card.patient.surname} ${card.patient.name} ${card.patient.patronymic}</a>
                </td>
                <td> ${card.dateOfAdmission} </td>
                <td> ${card.staff.surname} </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>

