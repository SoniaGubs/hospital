<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new card</title>
</head>
<body>


<c:url value="/createCard" var="createCardAction"/>

<sf:form method="post" action="${createCardAction}" modelAttribute="createCard">




<sf:label path="name">Name</sf:label> <sf:input path="name"/> <br>
<sf:label path="surname">Surname </sf:label> <sf:input path="surname"/> <br>
<sf:label path="title">Title </sf:label> <sf:input path="title"/> <br>
<input type="submit" value="Create Employee">

</sf:form>







<a href="<c:url value="/receptionist"/>"> Back to main page </a>



<%@include file="../common/footer.jsp" %>