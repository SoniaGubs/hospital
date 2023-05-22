<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <title>Nurse's main page</title>
</head>
<body>

Здравствуйте,  ${staff.name} ${staff.surname} ! <br>

Список пациентов: <br>

<c:forEach items="${sicks}" var="card">
<a href="<c:url value="/nurse/card?id=${card.id}"/>">  ${card.patient.surname} ${card.patient.name} ${card.patient.patronymic} </a> <br>
</c:forEach>


<%@include file="../common/footer.jsp" %>