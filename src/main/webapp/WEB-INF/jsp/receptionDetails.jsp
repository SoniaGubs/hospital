<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Patient's reception </title>
</head>
<body>

ФИО: ${reception.patient.name}  ${reception.patient.surname}<br>
Дата рождения: ${reception.patient.dob}<br>
Телефон: ${reception.patient.phone}<br>
Дата поступления: ${reception.dateOfAdmission} <br>

Диагноз:<br>
<c:forEach items="${reception.diagnoses}" var="diagnosis">
    ${diagnosis.diagnosis.diagnosisName}  <br>
</c:forEach><br>
Назначение:<br>
<c:forEach items="${reception.treatments}" var="treatment">
    ${treatment.treatmentType} -  ${treatment.drug} - ${treatment.operation} -${treatment.procedure}  <br>
</c:forEach><br>



<a href="<c:url value="/sicks"/>"> Back to reception list </a>


</body>
</html>