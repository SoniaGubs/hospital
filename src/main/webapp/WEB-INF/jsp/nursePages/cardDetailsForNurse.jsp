<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title> Patient's card </title>
</head>
<body>


ФИО: ${card.patient.surname} ${card.patient.name} ${card.patient.patronymic} <br>
Дата рождения: ${card.patient.dob}<br>
Телефон: ${card.patient.phone}<br>
Дата поступления : ${card.dateOfAdmission} <br>
<br>

Врач: ${card.staff.surname} ${card.staff.name} ${card.staff.patronymic}  <br>
<br>

Диагноз:
<br>
<c:forEach items="${card.diagnoses}" var="diagnosis">
    ${diagnosis.code}   ${diagnosis.diagnosisName}   <br>
</c:forEach>

Описание: ${card.descriptionDiagnosis} <br>


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
            <td><a href="<c:url value="/nurse/doTreatment?id=${treatment.id}&cardId=${card.id}"/>"> Выполнить </a><br></td>
        </tr>
    </c:forEach>
</table>
<br>

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


<br>
<a href="<c:url value="/nurse/nurseMainPage"/>"> Назад на главное меню </a>


</body>
</html>