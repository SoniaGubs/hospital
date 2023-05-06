<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List sicks</title>
</head>
<body>

Patient's list: <br>

<c:forEach items="${sicks}" var="card">
    <a href="<c:url value="/card?id=${card.id}"/>">  ${card.patient.surname} ${card.patient.name} ${card.patient.patronymic} </a> <br>
</c:forEach>


</body>
</html>