<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/languages.css" /> 
		<title>Languages</title>
	</head>
	<body>
		<div id="tableContainer" class="tableContainer">
			<table class="scrollTable">
				<thead class="fixedHeader" id="fixedHeader">
					<tr>
						<th><a href="#">Name</a></th>
						<th><a href="#">Creator</a></th>
						<th><a href="#">Version</a></th>
						<th><a href="#">Action</a></th>
					</tr>
				</thead>
				<tbody class="scrollContent">
					<c:forEach items="${languages}" var="l">
						<tr>
							<td>${l.getName()}</td>
							<td>${l.getCreator()}</td>
							<td>${l.getVersion()}</td>
							<td>
								<a href="">delete</a>
								<a href="">edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h1>New Language</h1>
		<form:form action="/languages" method="post" modelAttribute="language">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version"/>
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form>  		
	</body>
</html>