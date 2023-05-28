<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Doctors</title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>

<div class="container">
    <h2>Список врачей</h2>
    <div class="list">
    <form action="<c:url value="/doctor/setDoctor"/>">

            <select name="staffId" size="20">
                <c:forEach items="${doctors}" var="doctor">
                    <option value="${doctor.id}"> ${doctor.surname} ${doctor.name} ${doctor.patronymic} </option>
                </c:forEach>
            </select>

            <div class="button">
                <input type="hidden" name="cardId" value="${cardId}">
                <button type="submit" > Подтвердить </button>
            </div>


    </form>
    </div>
</div>

</body>
</html>