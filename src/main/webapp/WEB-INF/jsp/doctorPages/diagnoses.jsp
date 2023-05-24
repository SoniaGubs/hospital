<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>List diagnoses</title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>

<div class="container">
    <h1>Выберите диагнозы:</h1>
    <br>

    <c:url value="/doctor/setDiagnosis" var="setDiagnosisAction"/>
    <sf:form method="post" action="${setDiagnosisAction}" modelAttribute="cardSetDiagnosesDto">

        <div class="list">
            <h2>Диагнозы:</h2>

            <c:forEach items="${allDiagnoses}" var="diagnosis">
                <label> <sf:checkbox path="diagnoses" value="${diagnosis}"/>
                        ${diagnosis.code} ${diagnosis.diagnosisName} </label>
            </c:forEach>

            <h2>Дополнительная информация:</h2>
            <sf:textarea path="descriptionDiagnosis" rows="10"/> <br>
        </div>

        <div class="button">
            <sf:hidden path="id"/>
            <button type="submit"> Подтвердить</button>
        </div>
    </sf:form>
</div>


</body>
</html>