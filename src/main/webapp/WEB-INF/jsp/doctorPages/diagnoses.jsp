<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>List diagnoses</title>
</head>
<body>

Diagnoses:

<br>

<c:url value="/updateCard" var="updateCardAction"/>

<sf:form method="post" action="${updateCardAction}" modelAttribute="cardSetDiagnosesDto">

    <c:forEach items="${cardSetDiagnosesDto.startDiagnoses}" var="startDiagnosis">
        <label> <sf:checkbox path="startDiagnoses" value="${startDiagnosis.id}" checked="checked" />
                ${startDiagnosis.code} ${startDiagnosis.diagnosisName}</label> <br>
    </c:forEach>
    <c:forEach items="${cardSetDiagnosesDto.allRemainingDiagnoses}" var="allRemainingDiagnoses">
        <label> <sf:checkbox path="startDiagnoses" value="${allRemainingDiagnoses.id}"/>
                ${allRemainingDiagnoses.code} ${allRemainingDiagnoses.diagnosisName} </label> <br>
    </c:forEach>
    comment<br>
    <sf:input path="descriptionStartDiagnosis"/> <br>
    <sf:hidden path="id"/>
    <input type="reset">
    <input type="submit" value="Set diagnoses">

</sf:form>




</body>
</html>