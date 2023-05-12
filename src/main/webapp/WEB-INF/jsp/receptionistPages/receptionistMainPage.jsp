<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/main.css">
    <title>Receptionist's main page</title>
</head>
<body>

Hello, ${staff.name} ${staff.surname} ! <br>



<form action="<c:url value="/searchPatient"/>">
    <label>Surname: </label> <input name="surname" > <br>
    <label>Name: </label> <input name="name"> <br>
    <label>Patronymic: </label> <input name="patronymic"> <br>

    <input type="submit" value="Search patient">
</form>




<%@include file="../common/footer.jsp" %>