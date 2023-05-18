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

    <c:forEach items="${allDiagnoses}" var="diagnosis">

        <label> <sf:checkbox path="startDiagnoses" value="${diagnosis}"/>
                ${diagnosis.code} ${diagnosis.diagnosisName} </label> <br>

    </c:forEach>


    <label> Description </label><br>
    <sf:input path="descriptionStartDiagnosis"/> <br>
    <sf:hidden path="id"/>
    <input type="reset">
    <input type="submit" value="Set diagnoses">

</sf:form>


</body>
</html>