<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>사원관리</title>
</head>
<body>
	<h1>[사원 정보 보기]</h1>
	<hr>

	
	<form action="EmpUpdateServlet" method="post">
	
		<table border="1">
			
			<tr>
				<th>사원 번호</th>
				<td>${employeeInfo.empId }<input type="hidden" name="empId" value="${employeeInfo.empId }"></td>
			</tr>
			<tr>
				<th>사원 이름</th>
				<td>${employeeInfo.empName }<input type="hidden" name="empName" value="${employeeInfo.empName }"></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="empJobTitle" >
					<c:forEach var="empJob" items="${jobs }">
						<c:choose>	
							<c:when  test="${empJob.jobTitle eq employeeInfo.empJob}">
   								<option value="${empJob.jobId }"  selected="selected">${empJob.jobTitle }</option>
   							</c:when>
   							<c:otherwise>
   								<option value="${empJob.jobId }">${empJob.jobTitle }</option>
   							</c:otherwise>
   						</c:choose>
   					</c:forEach>
					</select>

				</td>
			</tr>
			<tr>
				<th>관리자</th>
				<td>${employeeInfo.empManagerId }<input type="hidden" name="empManagerId" value="${employeeInfo.empManagerId }"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<fmt:formatDate value="${employeeInfo.empHireDate }" pattern="yyyy-MM-dd" var="saved"/>
				<td>${saved }<input type="hidden"  name="empHireDate"  value="${saved }"></td>
			</tr>
			<tr>
				<th>월급</th>
				<td><input type="number" name="empSalary" value="${employeeInfo.empSalary }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="사원수정"></td>
			</tr>	
		</table>
	
	</form>
	<a href="<%=request.getContextPath()%>/EmpListServlet">목록 보기</a>
	<a href="<%=request.getContextPath()%>/EmpDeleteServlet?empId=${employeeInfo.empId }">삭제</a>
</body>
<script>
</script>
</html>