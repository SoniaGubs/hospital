<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.academy.hospital.model.entity.Gender" %>
<html>
<head>
    <link rel="stylesheet" href="/css/main.css">
    <title>Create new patient </title>
</head>
<body>


<c:url value="/createUpdatePatient" var="createUpdatePatientAction"/>

<sf:form method="post" action="${createUpdatePatientAction}" modelAttribute="patient">

<sf:label path="surname">Surname </sf:label>
    <sf:input  path="surname" required="required"/> <br>

<sf:label path="name">Name</sf:label>
    <sf:input path="name"  required="required"/> <br>

<sf:label path="patronymic">Patronymic</sf:label>
    <sf:input path="patronymic"/> <br>

<sf:label path="gender">Gender</sf:label>
    <sf:radiobutton path="gender" value="${Gender.MALE}" name="gender" checked="checked"/>
<sf:label path="gender" cssClass="light"> male </sf:label> <br>
    <sf:radiobutton path="gender" value="${Gender.FEMALE}" name="gender"/>
<sf:label path="gender" cssClass="light"> female </sf:label> <br>

<sf:label path="dob">dob</sf:label>
    <sf:input type="date" path="dob" required="required"/> <br>

<sf:label path="passport">Passport number </sf:label>
    <sf:input path="passport"/> <br>

<sf:label path="phone">Phone </sf:label>
    <sf:input path="phone"/> <br>

    <sf:hidden path="id" /> <br>
<button type="submit"> ok </button>
</sf:form>



<a href="<c:url value="/receptionist"/>"> Back to main page </a>

<br>


<%@include file="../common/footer.jsp" %>