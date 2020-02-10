<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script>

	con=false;
	
	
	function showTable() {
			/* con=${condition} */
			
			
			 var x=document.getElementById('table'); 
			 console.log("here");
			 debugger;
			if(x.style.visibility==='hidden'){
			
				console.log("here 1");
				debugger;
				x.style.visibility="visible";
			}
	
			
		}	
	</script> -->
	<!-- <script>
	$(document).ready(function(){
		$(#button).click(function(){
			$(#tableEmployee).show();
		});
	}); -->
	</script>
</head>
	

<!-- <body onload="javascript:hideTable()"> -->
	<!-- 
	
 -->
<body>

<script type="text/javascript"> 
function hideTable() {
	var x=document.getElementById('tableEmployee'); 
		x.style.visibility = "hidden";
	} 
	/*  function hideTable() {
		 var x=document.getElementById('table'); 
		if(x.style.visibility==='visible'){ 
		 	debugger;
		if(con===false){
			document.getElementById('table').style.display = "none";
		} */ 
		/* 
		var show=false;
		
		if(show=='false'){
			hideTable();
		}
		
		var button=document.getElementById('button');
		button.addEventListener('click', func());
		
		function func(){
			document.getElementById('tableEmployee').style.visibility="visible";
			show=true;
		}
		
		function hideTable(){
			document.getElementById('tableEmployee').style.visibility="hidden";
		}
		 */ 
		 
		 if(showTable){
			 document.getElementById('tableEmployee').style.visibility="visible";
		 }
		 else{
			 document.getElementById("tableEmployee").style.visibility="hidden";
		 }
</script>
	<div
		style="border: 1px solid black; width: 700px; height: 250px; margin-left: 500px">
		<div style="width: 100px; border: 1px black; margin-left: 100px"><jsp:include
				page="header.jsp" /></div>
		<div style="width: 150px; border: 1px black; margin-left: 250px">
			<form method="POST" id='formSubmit'>
				<table>
					<tr>
						<td><input name="id" type="number" id="contentId"/></td>
						<td colspan="2"><input type="submit" value="Seach" id="button" /></td>
					</tr>
				</table>
			</form>
		</div>

		<div align="center">${status}</div>
		<div style="margin-left: 10px; border: 1px">
			<table align="center" border="1"  id="tableEmployee">
				<%--  <c:choose>
		 	<c:when test="emp"> --%>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Task</th>
					<th>AssignedBy</th>
					<th>Status</th>
					<th>Image</th>
					<th colspan="2">Operation</th>
				</tr>
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.task}</td>
					<td>${employee.assignedBy}</td>
					<td>${employee.status}</td>
					<td><img src="data:image/jpg;base64,${image} " width="50"
						height="50"></td>
					<td><a
						href="<c:url value='/employee/update?id=${employee.id}'/>">
							Edit</a> | <a
						href="<c:url value='/employee/delete?id=${employee.id}' />">
							Delete</a> | <a
						href="<c:url value='/employee/upload?id=${employee.id}' />">
							Upload/Download</a>| <a
						href="<c:url value='/employee/image?id=${employee.id}' />">
							Upload/Change Image</a></td>
				</tr>
				<%-- 	</c:when>
				<c:otherwise>
            		<h2>Employee Not Found</h2>             
           		 </c:otherwise>	
			</c:choose> --%>
			</table>

		</div>
		<div align="center">
			<a href="<c:url value='/employee/add '/>"> Add Employee</a>
		</div>
		<div align="center">
			<a href="<c:url value='/employee/viewlist '/>"> View List</a>
		</div>

	</div>
</body>
</html>