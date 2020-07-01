<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>sa
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>1st Col</td>
			<td>2nd Col</td>
			<td>3rd Col</td>
		</tr>
		<tr>
			<c:forEach var="map" items="${map }">
				<td><c:out value="${ map.key}" /></td>
				<td><c:out value="${ map.value}" /></td>
				<td><c:out value="${ map.value}" /></td>
				</c:forEach>
		</tr>
	</table>
</body>
</html>