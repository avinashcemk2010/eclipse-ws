<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student registration form</title>
</head>
<body>

	<!-- when spring mvc is submitted Spring mvc will call: student.setFirstName -->
	<form:form action="processForm" modelAttribute="student">
		First Name:
		<form:input path="firstName" />
		<br>
		<br> Last Name:
		<form:input path="lastName" />
		<br>
		<br>
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		<br>
		Favorite Language:
			<form:radiobuttons path="favouriteLanguage" items="${student.favouriteLanguageOptions}"  />
		<br>
		<br>
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Centos <form:checkbox path="operatingSystems" value="Centos"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		<br>
		<br>
		<input type="submit" value="submit">
	</form:form>

</body>
</html>