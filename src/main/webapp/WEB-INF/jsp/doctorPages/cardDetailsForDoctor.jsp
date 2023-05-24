<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Medical Card</title>
    <link rel="stylesheet" href="/css/doctorStyle.css">
</head>
<body>
<div class="container">
    <h1>Карта</h1>

    <div class="info">
        <h2>Информация о пациенте</h2>
        <p>
            ФИО: ${card.patient.surname} ${card.patient.name} ${card.patient.patronymic} <br>
            Дата рождения: ${card.patient.dob}<br>
            Телефон: ${card.patient.phone}<br>
            Дата поступления: ${card.dateOfAdmission} <br>
            <a href="<c:url value="/doctor/showMedicalHistory?id=${card.patient.id}"/>"> История болезней </a>
        </p>
    </div>

    <div class="info">
        <h2>Лечащий врач</h2>
        <p>
            ${card.staff.surname} ${card.staff.name} ${card.staff.patronymic}
            <a href="<c:url value="/doctor/showSetDoctor?id=${card.id}"/>"> Изменить </a>
        </p>
    </div>

    <div class="info">
        <h2>Диагноз</h2>
        <p>
            <c:forEach items="${card.diagnoses}" var="diagnosis">
                ${diagnosis.code}   ${diagnosis.diagnosisName}   <br>
            </c:forEach>
            <br>
            Описание: ${card.descriptionDiagnosis} <br>
            <a href="<c:url value="/doctor/showAllDiagnoses?id=${card.id}"/>"> Установить диагноз</a>
        </p>
    </div>

    <div class="table">
        <h2>Назначенное лечение</h2>
        <table>
            <tr>
                <th>Дата назначения</th>
                <th>Тип</th>
                <th>Назначение</th>
            </tr>
            <c:forEach items="${treatmentsNotCompl}" var="treatment">
                <tr>
                    <td>${treatment.dateOfPrescription}</td>
                    <td>${treatment.treatmentType}</td>
                    <td>${treatment.prescription}</td>
                    <td><a href="<c:url value="/doctor/updateTreatment?id=${treatment.id}"/>">Изменить</a></td>
                    <td><a href="<c:url value="/doctor/deleteTreatment?id=${treatment.id}&cardId=${card.id}"/>">Удалить</a></td>
                    <td><a href="<c:url value="/doctor/doTreatment?id=${treatment.id}&cardId=${card.id}"/>">Выполнить</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="<c:url value="/doctor/addNewTreatment?cardId=${card.id}"/>">Добавить назначение</a>
    </div>

    <div class="table">
        <h2>Выполненное лечение</h2>
        <table>
            <tr>
                <th>Дата назначения</th>
                <th>Тип</th>
                <th>Назначение</th>
                <th>Дата выполнения</th>
                <th>Выполнил</th>
            </tr>
            <c:forEach items="${treatmentsCompl}" var="treatment">
                <tr>
                    <td>${treatment.dateOfPrescription}</td>
                    <td>${treatment.treatmentType}</td>
                    <td>${treatment.prescription}</td>
                    <td>${treatment.dateOfCompletion}</td>
                    <td>${treatment.staff.surname} ${treatment.staff.name} ${treatment.staff.patronymic}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="button">
        <button onclick="checkDetails()">Выписать</button>
        <script>
            function checkDetails() {
                if (${card.staff != null && card.staff != ''}) {
                    if (${not empty card.diagnoses}) {
                        window.location.href = "<c:url value='/doctor/goToDischarge?id=${card.id}'/>";
                    } else {
                        alert("Пожалуйста, укажите диагнозы пациента.");
                    }
                } else {
                    alert("Пожалуйста, введите информацию о враче.");
                }
            }
        </script>
    </div>

    <div class="links">
        <a href="<c:url value="/doctor/doctorMainPage"/>">Назад на главное меню</a>
    </div>
</div>
</body>
</html>