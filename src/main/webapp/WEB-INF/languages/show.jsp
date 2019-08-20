<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>${language.getName()}</title>
		</head>
	<body>
		<h1><c:out value="${language.getName()}"/></h1>
		<p>Creator: <c:out value="${language.getCreator()}"/></p>
		<p>Version: <c:out value="${language.getVersion()}"/></p>
		<a href="/books/${language.getId()}/edit">Edit Language</a>
		<form action="/books/${language.getId()}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</body>
</html>