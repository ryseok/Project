<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Funshop_공지사항</title>
<style type="text/css">
#title {
            display: inline-block;
            width: 300px;
            height: 100%;
            background-color: aqua;
        }

#contentsView {
            display: inline-block;
            width: 300px;
            height: 100%;
            background-color: orange;
        }
</style>
</head>
<%--notice.jsp--%>
<body>
	<br><br><br><br>
	<h1 align="center">공지사항</h1>
	<br>
	<div align="center">	
		<c:forEach items="${list }" var="noticeUser" varStatus="stat">
			<div 
					data-toggle="collapse"
					data-target="#contents${stat.count }" id="title">
				${noticeUser.write }
			</div>
			<div id="contents${stat.count }" class="collapse">
			    <div id="contentsView">${noticeUser.contents}</div>					
			</div>
			<br><br>
		</c:forEach>
	</div>	
</body>
</html>