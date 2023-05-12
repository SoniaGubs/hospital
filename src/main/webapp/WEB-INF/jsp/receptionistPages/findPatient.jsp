<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Found Patients </title>

</head>
<body>


<br>
<a href="<c:url value="/showCreatePatient"/>"> Create new patient </a> <br>
<br>

Found patients:<br>

<c:forEach items="${patients}" var="patient">
<a href="<c:url value="/patient?id=${patient.id}"/>">  ${patient.surname} ${patient.name} ${patient.patronymic} ${patient.dob}</a>
<br>
</c:forEach>


<br>


<%@include file="../common/footer.jsp" %>