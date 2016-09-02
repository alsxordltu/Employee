<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="list"/>
	<fmt:bundle basename="title.title">
	
	<h1><fmt:message key="title"></fmt:message></h1>
	</fmt:bundle>
	<hr>
	<%=request.getParameter("title")%>
	
</body>
<script>
</script>
</html>