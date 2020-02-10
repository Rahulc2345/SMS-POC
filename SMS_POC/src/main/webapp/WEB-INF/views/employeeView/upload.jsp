<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="width:100px;border:1px black;margin-left:550px" ><jsp:include page="header.jsp" /></div> 

	<div align="center">
		<h3>Upload files here</h3>
		<form:form modelAttribute="fileBucket" method="POST" enctype="multipart/form-data" >
			<table>
				<tr>
					<td>File</td>
					<td><form:input type="file" path="file" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input type="text" path="descriptor" /></td>
				</tr>
			</table>
			<input type="submit" value="Upload" />
		</form:form>
	</div>

	<div align="center"><h3>Your List of files</h3></div>
	<div align="center" ><h2>${status}</h2></div>
	<div align="center" >
		<table border="1">
			<tr>
				<td>No.</td>
				<td>File Name</td>
				<td>Type</td>
				<td>Description</td>
				<td>Download</td>
				<td>Delete</td>
			</tr>
			<tr>
				<c:forEach items="${documents}" var="doc" varStatus="counter">
					<tr>
						<td>${counter.index+1}</td>
						<td>${doc.name}</td>
						<td>${doc.description}</td>
						<td>${doc.type}</td>
						<td><a href="<c:url value='/employee/download/${employee.id}/${doc.documentId}' />">Download</a></td> |
						<td><a href="<c:url value='/employee/delete/${employee.id}/${doc.documentId}' />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		
		<div align="center"><a href="<c:url value='/employee/deleteAll/${employee.id}' />"> Delete All Your Documents</a></div>
	</div>

</body>
</html>