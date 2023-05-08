<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List diagnoses</title>
</head>
<body>

Diagnoses: <br>

<c:forEach items="${diagnoses}" var="diagnosis">
    ${diagnosis.code} ${diagnosis.diagnosisName} </a> <br>
</c:forEach>


</body>
</html>