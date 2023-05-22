<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>  Details medical History   </title>
</head>
<body>


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

</body>
</html>