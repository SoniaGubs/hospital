<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Doctors</title>
</head>
<body>

<h2>Список врачей</h2>



<form action="<c:url value="/doctor/setDoctor"/>">


    <select name="staffId" size="20">
        <c:forEach items="${doctors}" var="doctor">
            <option value="${doctor.id}">${doctor.surname} ${doctor.name} ${doctor.patronymic}</option>
        </c:forEach>
    </select><br><br>
    <input type="hidden"  name="cardId" value="${cardId}">
    <input type="submit" value="ок">
</form>

<br>




</body>
</html>