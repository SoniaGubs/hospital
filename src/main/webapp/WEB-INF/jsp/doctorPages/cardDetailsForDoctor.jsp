<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title> Patient's card </title>
</head>
<body>

<br>
<a href="<c:url value="/doctor/showMedicalHistory?id=${card.patient.id}"/>"> История болезней </a>
<br>

ФИО: ${card.patient.surname} ${card.patient.name} ${card.patient.patronymic} <br>
Дата рождения: ${card.patient.dob}<br>
Телефон: ${card.patient.phone}<br>
Дата поступления : ${card.dateOfAdmission} <br>
<br>

Врач: ${card.staff.surname} ${card.staff.name} ${card.staff.patronymic} <a
        href="<c:url value="/doctor/showSetDoctor?id=${card.id}"/>"> Изменить </a> <br>
<br>

Диагноз:
<br>
<c:forEach items="${card.diagnoses}" var="diagnosis">
    ${diagnosis.code}   ${diagnosis.diagnosisName}   <br>
</c:forEach>

Описание: ${card.descriptionDiagnosis} <br>

<a href="<c:url value="/doctor/showAllDiagnoses?id=${card.id}"/>"> Установить диагноз</a>

<br>

<table>
    <caption> Назначенное лечение</caption>
    <tr>
        <th> Дата назначения</th>
        <th> Тип</th>
        <th> Назначение</th>
    </tr>

    <c:forEach items="${treatmentsNotCompl}" var="treatment">
        <tr>
            <td> ${treatment.dateOfPrescription} </td>
            <td> ${treatment.treatmentType} </td>
            <td> ${treatment.prescription} </td>
            <td><a href="<c:url value="/doctor/updateTreatment?id=${treatment.id}"/>"> Изменить </a><br></td>
            <td><a href="<c:url value="/doctor/deleteTreatment?id=${treatment.id}&cardId=${card.id}"/>"> Удалить </a><br></td>

            <td><a href="<c:url value="/doctor/doTreatment?id=${treatment.id}&cardId=${card.id}"/>"> Выполнить </a><br></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="<c:url value="/doctor/addNewTreatment?cardId=${card.id}"/>">добавить назначение </a>

<br>
<table>
    <caption> Выполненное лечение :</caption>
    <tr>
        <th> Дата назначения</th>
        <th> Тип</th>
        <th> Назначение</th>
        <th> Дата выполнения</th>
        <th> Выполнил</th>
    </tr>

    <c:forEach items="${treatmentsCompl}" var="treatment">
        <tr>
            <td> ${treatment.dateOfPrescription} </td>
            <td> ${treatment.treatmentType} </td>
            <td> ${treatment.prescription} </td>
            <td> ${treatment.dateOfCompletion} </td>
            <td> ${treatment.staff} </td>
        </tr>
    </c:forEach>
</table>


<button onclick="checkDetails()">Выписать</button>
<script>
    function checkDetails() {
        if (${card.staff != null && card.staff != ''}) {
            if (${not empty card.diagnoses}) {
                window.location.href = "<c:url value='/doctor/goToDischarge?id=${card.id}'/>";
            } else {
                alert("Пожалуйста, укажите диагнозы пациента.");
            }
        } else {
            alert("Пожалуйста, введите информацию о враче.");
        }
    }
</script>
<br>

<br>
<a href="<c:url value="/doctor/doctorMainPage"/>"> Назад на главное меню </a>


</body>
</html>