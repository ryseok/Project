<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="/Funshop/image/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인한 후 메인페이지</title>

</head>
<body>
<c:choose>
	<c:when test="${sessionScope.id!=null }">
		메인<br>
		${sessionScope.id }<br>
		<%-- ${id } --%>
		<%-- ${user.id } --%>

		<!-- <a href="/Funshop/login.do?action=loginForm" ></a> -->
		<a href="/Funshop/login.do?action=logout">로그아웃</a>	
	</c:when>
	<%-- 
	<c:otherwise>
		<script>
		alert('ID나 PW가 잘못되었거나 로그인을 하지 않으셨습니다.');		
		window.location.href="/Funshop/login.do?action=loginForm";
		</script>
	</c:otherwise>
	 --%>
</c:choose>
<%-- 메인<br>
${sessionScope.id }<br>
${id }
${user.id }

<!-- <a href="/Funshop/login.do?action=loginForm" ></a> -->
<a href="/Funshop/login.do?action=logout">로그아웃</a> --%>

</body>
</html>