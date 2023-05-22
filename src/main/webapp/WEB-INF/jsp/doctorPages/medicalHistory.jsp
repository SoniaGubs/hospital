<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title> Medical history </title>
</head>
<body>


<table>
    <caption> История болезней </caption>
    <tr>
        <th> Дата поступления </th>
        <th> Дата выписки </th>
        <th> Заключительный диагноз </th>
        <th> Описание диагноза </th>
        <th> Лечащий врач </th>
        <th> Выполненное лечение</th>
    </tr>

    <c:forEach items="${allPatientsCards}" var="card">
    <tr>
        <td> ${card.dateOfAdmission} </td>
        <td> ${card.dateOfDischarge} </td>
        <td>
        <c:forEach items="${card.diagnoses}" var="diagnosis">
            ${diagnosis.code}  ${diagnosis.diagnosisName} <br>
        </c:forEach>
        </td>
        <td> ${card.descriptionDiagnosis} </td>
        <td>  ${card.staff.surname} ${card.staff.name} ${card.staff.patronymic} </td>
        <td> <a href="<c:url value="/doctor/showDetailsMedicalHistory/${card.id}"/>"> выполненное лечение </a><br> </td>
    </tr>
        </c:forEach>


</table>


<br>



</body>
</html>