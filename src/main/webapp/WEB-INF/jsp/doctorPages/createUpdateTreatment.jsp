<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.academy.hospital.model.entity.TreatmentType" %>
<html>
<head>

    <title>Create Treatment </title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>
<div class="container">
    <h1>Назначение</h1>

    <c:url value="/doctor/createTreatment" var="createTreatmentAction"/>
    <sf:form method="post" action="${createTreatmentAction}" modelAttribute="treatment">

        <div class="list">
            <h2>Тип назначения</h2>

            <label> <sf:radiobutton path="treatmentType" value="${TreatmentType.DRUG}" name="treatmentType"
                                    checked="checked"/>
                Лекарство </label>

            <label> <sf:radiobutton path="treatmentType" value="${TreatmentType.PROCEDURE}" name="treatmentType"/>
                Процедура </label>

            <label> <sf:radiobutton path="treatmentType" value="${TreatmentType.OPERATION}" name="treatmentType"/>
                Операция </label>


            <h2>назначение </h2>
            <sf:textarea path="prescription" required="required" rows="10"/> <br>

            <sf:hidden path="card.id"/> <br>
            <sf:hidden path="id"/> <br>
        </div>

        <div class="button">
            <button type="submit" > Подтвердить </button>
        </div>
    </sf:form>

</div>

<br>

</body>
</html>