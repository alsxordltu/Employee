<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>사원관리</title>
<style>
	
</style>
</head>
<body>
	<h1>[사원 목록]</h1>
	
	<hr>
	<table border="1">
		<tr>
			<td colspan="5">검색 form</td>
		</tr>
		<tr>
			<td>정렬기준</td>
			<td colspan="4">정렬 form</td>
		</tr>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>직업</th>
			<th>입사일</th>
			<th>월급</th>
		</tr>
	<c:forEach var="employee" items="${employees }">
		<tr>
			<td><a href="<%=request.getContextPath()%>/EmpRetrieveServlet?empId=${employee.empId }">${employee.empId }</a></td>
			<td>${employee.empName }</td>
			<td>${employee.empJob }</td>
			<fmt:formatDate value="${employee.empHireDate }" pattern="yyyy-MM-dd" var="saved"/>
			<td>${saved }</td>
			<td>${employee.empSalary }</td>
		</tr>
	</c:forEach>	
	</table>
	<a href="<%=request.getContextPath()%>/EmpWriteFormServlet" >사원등록</a>
	
</body>

<script>
</script>
</html>