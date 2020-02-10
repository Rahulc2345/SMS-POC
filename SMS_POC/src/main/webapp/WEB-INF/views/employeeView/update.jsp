<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="employee_update">
        <table>
        <tr>
                <td>ID </td>
                <td><form:input path="id" readonly="true"/></td>  
            </tr>
            <tr>
                <td>Name </td>
                <td><form:input path="name" readonly="true"/></td>  
            </tr>
            <tr>
                <td>Task </td>
                <td><form:input path="task" /></td>
            </tr>
                 <tr>
                <td>AssignedBy</td>
                <td><form:input path="assignedBy"/></td>
            </tr>
            <tr>
                <td>Status </td>
               <td> <form:select  path="status">
              		<form:option value="pending"> Pending</form:option>
              		<form:option value="completed"> Completed</form:option>
        		  </form:select>
        		 </td> 
            </tr>
            <tr>
                <td colspan="3">
               		<button>Update</button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>