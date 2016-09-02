<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사원관리</title>
</head>
<body>
	<h1>[사원 등록]</h1>
		
	<hr>
	<form action="EmpWriteServlet" method="post">
		<table border="1">
			
			<tr>
				<th>사원 번호</th>
				<td><input type="number" name="empId"></td>
			</tr>
			<tr>
				<th>사원 이름</th>
				<td><input type="text" name="empName"></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="empJobTitle">
					<c:forEach var="job" items="${jobs}">
   						<option value="${job.jobId }">${job.jobTitle }</option>
   					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>관리자</th>
				<td><input type="number" name="empManagerId"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" value="sysdate" name="empHireDate" readonly="readonly"></td>
			</tr>
			<tr>
				<th>월급</th>
				<td><input type="number" name="empSalary"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="사원등록">    <button onclick="window.location.href='<%=request.getContextPath()%>/EmpWriteFormServlet'">다시입력</button></td>
			</tr>	
		</table>
	</form>
	<a href="<%=request.getContextPath()%>/EmpListServlet">목록 보기</a>
</body>
<script>
</script>
</html>