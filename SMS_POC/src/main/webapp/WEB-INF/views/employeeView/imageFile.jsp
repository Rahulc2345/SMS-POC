<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h2>${uploadStatus}</h2></div>
	<form:form modelAttribute="image" method="POST" enctype="multipart/form-data">
		<form:input path="iFile" type="file"/>
		<input type="submit" value="upload image" />
	</form:form>
	<a href="${pageContext.request.contextPath}/employee/search">Home</a>
</body>
</html>