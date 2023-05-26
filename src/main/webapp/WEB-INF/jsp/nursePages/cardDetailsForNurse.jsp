<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.academy.hospital.model.entity.TreatmentType" %>

<html>
<head>
    <title> Patient's card </title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>
<div class="container">
    <h1>Карта</h1>

    <div class="info">
        <h2>Информация о пациенте</h2>
        <p>
            ФИО: ${card.patient.surname} ${card.patient.name} ${card.patient.patronymic} <br>
            Дата рождения: ${card.patient.dob}<br>
            Телефон: ${card.patient.phone}<br>
            Дата поступления: ${card.dateOfAdmission} <br>
        </p>
    </div>

    <div class="info">
        <h2>Лечащий врач</h2>
        <p>
            ${card.staff.surname} ${card.staff.name} ${card.staff.patronymic}
        </p>
    </div>

    <div class="info">
        <h2>Диагноз</h2>
        <p>
            <c:forEach items="${card.diagnoses}" var="diagnosis">
                ${diagnosis.code}   ${diagnosis.diagnosisName}   <br>
            </c:forEach>
            <br>
            Описание: ${card.descriptionDiagnosis} <br>
        </p>
    </div>

    <div class="table">
        <h2>Назначенное лечение</h2>
        <table>
            <tr>
                <th>Дата назначения</th>
                <th>Тип</th>
                <th>Назначение</th>
            </tr>
            <c:forEach items="${treatmentsNotCompl}" var="treatment">
                <tr>
                    <td>${treatment.dateOfPrescription}</td>
                    <td>${treatment.treatmentType.label}</td>
                    <td>${treatment.prescription}</td>
                    <td><c:if test="${treatment.treatmentType == 'DRUG' || treatment.treatmentType == 'PROCEDURE'}">
                        <a href="<c:url value="/nurse/doTreatment?id=${treatment.id}&cardId=${card.id}"/>">
                            Выполнить </a><br>
                    </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="table">
        <h2>Выполненное лечение</h2>
        <table>
            <tr>
                <th>Дата назначения</th>
                <th>Тип</th>
                <th>Назначение</th>
                <th>Дата выполнения</th>
                <th>Выполнил</th>
            </tr>
            <c:forEach items="${treatmentsCompl}" var="treatment">
                <tr>
                    <td>${treatment.dateOfPrescription}</td>
                    <td>${treatment.treatmentType.label}</td>
                    <td>${treatment.prescription}</td>
                    <td>${treatment.dateOfCompletion}</td>
                    <td>${treatment.staff.surname} ${treatment.staff.name} ${treatment.staff.patronymic}</td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <div class="links">
        <a href="<c:url value="/nurse/nurseMainPage"/>"> Назад на главное меню </a>
    </div>
</div>
</body>
</html>

