<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Details medical History </title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>

<div class="container">
    <div class="table">
        <h1> Выполненное лечение</h1>
        <table>
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
                    <td> ${treatment.treatmentType.label} </td>
                    <td> ${treatment.prescription} </td>
                    <td> ${treatment.dateOfCompletion} </td>
                    <td> ${treatment.staff.surname} ${treatment.staff.name} ${treatment.staff.patronymic} </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>