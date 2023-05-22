<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.academy.hospital.model.entity.TreatmentType" %>
<html>
<head>

    <title>Create Treatment </title>
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>

<c:url value="/doctor/createTreatment" var="createTreatmentAction"/>
<sf:form method="post" action="${createTreatmentAction}" modelAttribute="treatment">

<sf:label path="treatmentType">Тип назначения </sf:label>
    <sf:radiobutton path="treatmentType" value="${TreatmentType.DRUG}" name="treatmentType" checked="checked"/>
<sf:label path="treatmentType" cssClass="light"> drug </sf:label> <br>
    <sf:radiobutton path="treatmentType" value="${TreatmentType.PROCEDURE}" name="treatmentType"/>
<sf:label path="treatmentType" cssClass="light"> procedure </sf:label> <br>
    <sf:radiobutton path="treatmentType" value="${TreatmentType.OPERATION}" name="treatmentType"/>
<sf:label path="treatmentType" cssClass="light"> operation </sf:label> <br>


<sf:label path="prescription">назначение </sf:label>
    <sf:input path="prescription" required="required"/> <br>

    <sf:hidden path="card.id"/> <br>
    <sf:hidden path="id" /> <br>

<input type="submit" value="подтвердить"/>
</sf:form>



<br>


<%@include file="../common/footer.jsp" %>