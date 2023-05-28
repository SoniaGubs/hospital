<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Receptionist's main page</title>
    <link rel="stylesheet" href="/css/simpleStyle.css">

</head>
<body>

<div class="container">
    <div class="form-container">

        <h1> Здравствуйте, <br>
            ${staff.surname} ${staff.name} ${staff.patronymic}  </h1>
        <br>

        <br>
        <p>Вы можете ввести фамилию или фамилию и имя, или же полное фио для лучшего поиска</p>


        <form action="<c:url value="/receptionist/searchPatient"/>">
            <div class="form-row">
                <label class="label" for="surname"> Фамилия: </label>
                <input id="surname" name="surname" type="text" class="input-text" required > <br>
            </div>
            <div class="form-row">
                <label class="label" for="name">Имя: </label>
                <input id="name" name="name"  type="text" class="input-text"><br>
            </div>
            <div class="form-row">
                <label class="label" for="patronymic">Отчество: </label>
                <input id="patronymic" name="patronymic" type="text" class="input-text"> <br>
            </div>
            <button type="submit" class="submit-button"> Поиск пациента</button>
        </form>
    </div>
</div>
</body>
</html>