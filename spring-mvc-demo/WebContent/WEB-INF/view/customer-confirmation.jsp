<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer confirmation page</title>
</head>
<body>

Customer Details: ${ customer.firstName } ${customer.lastName }
Free Passes: ${ customer.freePasses }
Postal code: ${ customer.postalCode }
Course code: ${ customer.courseCode }

</body>
</html>