<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.academy.hospital.model.entity.TreatmentType" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title> Patient's card </title>
</head>
<body>


Surname: ${card.patient.surname}<br>
Name: ${card.patient.name} <br>
Patronymic: ${card.patient.patronymic} <br>
Date of birth: ${card.patient.dob}<br>
Phone: ${card.patient.phone}<br>
Date of admission : ${card.dateOfAdmission} <br>

Diagnoses:
<br>
<c:forEach items="${card.startDiagnoses}" var="startDiagnosis">
    ${startDiagnosis.code}   ${startDiagnosis.diagnosisName}   <br>
</c:forEach>

Description: ${card.descriptionStartDiagnosis} <br>

<a href="<c:url value="/showAllDiagnoses?id=${card.id}"/>"> Set diagnoses</a>

<br>

<br>


<table>
    <caption> Treatment</caption>
    <tr>
        <th> Date of prescription</th>
        <th> Type</th>
        <th> Prescription</th>
    </tr>

    <c:forEach items="${treatmentsNotCompl}" var="treatment">
        <tr>
            <td> ${treatment.dateOfPrescription} </td>
            <td> ${treatment.treatmentType} </td>
            <td> ${treatment.prescription} </td>
            <td> <a href="<c:url value="/updateTreatment?id=${treatment.id}"/>"> Update </a><br> </td>
            <td> <a href="<c:url value="/?id=${treatment.id}"/>"> Delete </a><br> </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="<c:url value="/addNewTreatment?cardId=${card.id}"/>">add treatments</a>

<br>
<table>
    <caption> Completed treatments:</caption>
    <tr>
        <th> Date of prescription</th>
        <th> Type</th>
        <th> Prescription</th>
        <th> Date of completion</th>
        <th> staff </th>
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

<c:forEach items="${treatmentsCompl}" var="treatment">
    ${treatment.treatmentType}  ${treatment.dateOfPrescription}  ${treatment.prescription} ${treatment.staff}<br>
</c:forEach>
<br>



<br>

<br>
<a href="<c:url value="/sicks"/>"> Back to cards list </a>


</body>
</html>