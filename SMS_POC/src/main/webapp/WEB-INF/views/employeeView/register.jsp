<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<%--<div><a href="<spring:url value='${pageContext.request.contextPath}/add?mylocale=en' />" > English </a> | 
			<a href="<spring:url value='${pageContext.request.contextPath}/add?mylocale=gn' />" > German </a>
	 </div> --%>

	<div>
		<h3>
			<spring:url var="url" value="">
				<spring:param name="mylocale">en</spring:param>
			</spring:url>
			<a href="${url}">English</a> |
			<spring:url var="url" value="">
				<spring:param name="mylocale">gn</spring:param>
			</spring:url>
			<a href="${url}">German</a> |
			<spring:url var="url" value="">
				<spring:param name="mylocale">spn</spring:param>
			</spring:url>
			<a href="${url}">Spanish</a> |
			<spring:url var="url" value="">
				<spring:param name="mylocale">mr</spring:param>
			</spring:url>
			<a href="${url}">मराठी</a>
		</h3>
	</div>
	<div>
		<label>${message} </label>
	</div>


	<form:form modelAttribute="employee" method="POST"> <%-- enctype="multipart/form-data"> --%>
		<table>
			<tr>
				<td><spring:message code="lable.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>

				<td><spring:message code="lable.task" /></td>
				<td><form:input path="task" /></td>
				<td><form:errors path="task" cssClass="error" /></td>
			</tr>
			<tr>

				<td><spring:message code="lable.assignedBy" /></td>
				<td><form:input path="assignedBy" /></td>
				<td><form:errors path="assignedBy" cssClass="error" /></td>
			</tr>
			<%--  <tr>
				<td><spring:message code="lable.image" /></td>
				<td><form:input path="image" type="file" /></td>
				<td><form:errors path="image" cssClass="error" /></td>
			</tr> --%>
			<tr>
				<td><spring:message code="lable.status" /></td>
				<td><form:select path="status">
						<form:option value="pending"> Pending</form:option>
						<form:option value="completed"> Completed</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="<spring:message code="lable.submit" />" /></td>
			</tr>
		</table>
	</form:form>



</body>
</html>