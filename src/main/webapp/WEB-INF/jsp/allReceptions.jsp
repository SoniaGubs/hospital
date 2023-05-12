<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All</title>
</head>
<body>


<c:forEach items="${allReceptions}" var="card">
    <a href="<c:url value="/card?id=${card.id}"/>"> ${card.patient.name} - ${card.patient.surname} </a> <br>
</c:forEach>


</body>
</html>