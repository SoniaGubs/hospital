<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List sicks</title>
</head>
<body>


<c:forEach items="${sicks}" var="reception">
    <a href="<c:url value="/reception?id=${reception.id}"/>"> ${reception.patient.name} - ${reception.patient.surname} </a> <br>
</c:forEach>


</body>
</html>