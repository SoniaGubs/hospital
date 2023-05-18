<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Success Card</title>
</head>
<body>

Date of admission : ${card.dateOfAdmission} <br>
Surname: ${card.patient.surname}<br>
Name: ${card.patient.name} <br>
Patronymic: ${card.patient.patronymic} <br>


<a href="<c:url value="/receptionist"/>"> Back to main page </a>

<br>

</body>
</html>