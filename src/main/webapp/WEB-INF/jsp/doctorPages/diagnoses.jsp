<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>List diagnoses</title>
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>

Выберите диагнозы:

<br>

<c:url value="/doctor/setDiagnosis" var="setDiagnosisAction"/>

<sf:form method="post" action="${setDiagnosisAction}" modelAttribute="cardSetDiagnosesDto">

    <c:forEach items="${allDiagnoses}" var="diagnosis">
        <label> <sf:checkbox path="diagnoses" value="${diagnosis}"/>
                ${diagnosis.code} ${diagnosis.diagnosisName} </label> <br>
    </c:forEach>

    <label> Description </label><br>
    <sf:input path="descriptionDiagnosis"/> <br>
    <sf:hidden path="id"/>
    <input type="reset">
    <input type="submit" value="Подтвердить">

</sf:form>


</body>
</html>