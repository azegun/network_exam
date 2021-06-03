<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <c:set var="contextPath" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">	
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>			
		<script type="text/javascript">
	$(function() {
		var contextPath = "${contextPath}";
		$.get(contextPath + "/api/employees", 
		function(json) {			
			var dataLength = json.length;
			
			if (dataLength >= 1) {
				var sCont = "";
				for (i = 0; i < dataLength; i++) {
						sCont += "<tr>";
						sCont += "<td>"+ json[i].empNo + "</td>";
						sCont += "<td><a href='read?empNo=" + json[i].empNo + "'>"
																	+ json[i].empName + "</a></td>";
						sCont += "<td>" + json[i].title.name + "</td>";
				if(json[i].manager != null){
						sCont += "<td>" + json[i].manager.empNo + "</td>";
				}else{
						sCont += "<td></td>"
						}
						sCont += "<td>" + json[i].salary + "</td>";
						sCont += "<td>" + json[i].dept.dNo + "</td>";
						sCont += "</tr>";
					}				
				$("#load:last-child").append(sCont);		
		
			};
		});
	});
</script>
</head>
<body>
	<h2>
    <spring:message code="employee" />
    <spring:message code="list" />
</h2>

<table border="1">
       <thead>
       <tr>
        <td><spring:message code="eno" /></td>
        <td><spring:message code="ename" /></td>
        <td><spring:message code="title" /></td>
        <td><spring:message code="manager" /></td>
        <td><spring:message code="salary" /></td>
        <td><spring:message code="dept" /></td>
        </tr>
    </thead>
       <tbody id="load">
       </tbody>
</table>
</body>
</html>