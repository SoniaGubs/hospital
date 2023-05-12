<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <title>Doctor's main page</title>
</head>
<body>

Hello, doctor ${staff.name} ${staff.surname} ! <br>

<br>
<a href="<c:url value="/sicks"/>"> Patients </a> <br>
<br>

<%@include file="../common/footer.jsp" %>