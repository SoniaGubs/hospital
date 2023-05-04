<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All</title>
</head>
<body>


<c:forEach items="${allReceptions}" var="reception">
    <a href="<c:url value="/reception?id=${reception.id}"/>"> ${reception.patient.name} - ${reception.patient.surname} </a> <br>
</c:forEach>


</body>
</html>