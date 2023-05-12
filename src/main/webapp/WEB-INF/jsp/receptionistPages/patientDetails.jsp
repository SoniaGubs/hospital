<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Patient</title>
</head>
<body>

Surname: ${patient.surname}<br>
Name: ${patient.name} <br>
Patronymic: ${patient.patronymic} <br>
Date of birth: ${patient.dob}<br>
Gender ${patient.gender}<br>
Phone: ${patient.phone}<br>
Phone: ${patient.passport}<br>


<c:url value="/updatePatient" var="updatePatientAction"/>
<sf:form method="post" action="${updatePatientAction}" modelAttribute="patient">
    <sf:hidden path="surname" /> <br>
    <sf:hidden path="name" /> <br>
    <sf:hidden path="patronymic"/> <br>
    <sf:hidden path="gender"/> <br>
    <sf:hidden path="dob" /> <br>
    <sf:hidden path="passport"/> <br>
    <sf:hidden path="phone"/> <br>
    <input type="submit" value="Update">
</sf:form>


<a href="<c:url value="/createCard?id=${patient.id}"/>"> create card </a>



<a href="<c:url value=""/>"> Back to employee list </a>

</body>
</html>