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



Treatment:             <br>

Procedure:
<c:forEach items="${card.treatments}" var="treatment">
    <c:if test="${treatment.treatmentType eq TreatmentType.PROCEDURE}">
        ${treatment.procedure}  <br>
    </c:if>
</c:forEach>

Drugs:
<c:forEach items="${card.treatments}" var="treatment">
    <c:if test="${treatment.treatmentType eq TreatmentType.DRUG }">
        ${treatment.drug}  <br>
    </c:if>
</c:forEach>

Operations:
<c:forEach items="${card.treatments}" var="treatment">
    <c:if test="${treatment.treatmentType eq TreatmentType.OPERATION}">
        ${treatment.operation}  <br>
    </c:if>
</c:forEach>
<br>


<a href="<c:url value="/showAllDiagnoses?id=${card.id}"/>"> Set diagnoses</a>




<br>

Diagnoses:
<c:forEach items="${card.startDiagnoses}" var="startDiagnosis">
        ${startDiagnosis.code}   ${startDiagnosis.diagnosisName}   <br>
</c:forEach>

Description: ${card.descriptionStartDiagnosis} <br>



<a href="<c:url value="/sicks"/>"> Back to cards list </a>


</body>
</html>