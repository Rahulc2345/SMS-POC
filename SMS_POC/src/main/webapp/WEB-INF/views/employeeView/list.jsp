<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="width:100px;border:1px black;margin-left:550px" ><jsp:include page="header.jsp"/></div> 
 
	<div style="margin-left:20px;border: 1px">
		 <table align="center" border="1" >
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Task</th>
				<th>AssignedBy</th>
				<th>Image</th>
				 <th>Status</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="emp" items="${list}" varStatus="counter">			
				<tr>	
					<td>${emp.id} </td>
					<td>${emp.name} </td>
					<td>${emp.task} </td>
					<td>${emp.assignedBy} </td>
				 	<td><img src="data:image/jpg;base64,${image[counter.index]} " width="50" height="50"></td>
				 	
					<td>${emp.status} </td> 
					
					<td><a href="<c:url value='/employee/update?id=${emp.id}'/>" >Edit</a> | 
						<a href="<c:url value='/employee/delete?id=${emp.id}' />" >Delete</a> |
						<a href="<c:url value='/employee/upload?id=${emp.id} ' />" >View/Upload/Download documents</a> |	
						<a href="<c:url value='/employee/image?id=${emp.id}' />" > Upload/Change Image</a>
					</td> 
								
				</tr>
			</c:forEach>	
		</table>
		<div align="center"><a href="<c:url value='/employee/add '/>" > Add Employee</a></div>
	</div>
</body>
</html>