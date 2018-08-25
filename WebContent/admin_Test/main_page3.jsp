<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="/Funshop/image/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script type="text/javascript">
	$(function() {

		$("#member").click(function() {
			$.ajax({
				url : "/Funshop/admin_member/memberList.do",
				success : function(result) {
					$("#view").html(result);
				}
			});
		});

		$("#notice").click(function() {
			$.ajax({
				url : "/Funshop/admin_notice/noticeList.do",
				success : function(result) {
					$("#view").html(result);
				}
			});
		});
	});
</script>
<title>Funshop_메인 페이지</title>
</head>
<body>
	<!-- Nav tabs -->
	<div class="container mt-3">
		<h2>관리자 페이지</h2>
		<br>
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				href="/Funshop/admin_main/main_page3.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="#" id="member">Member</a></li>
			<li class="nav-item"><a class="nav-link" href="#" id="notice">Notice</a></li>
		</ul>

		<!-- Tab panes -->
		<div id="view" class="tab-content">
			<br>
			<h3>&#169;Funshop 주식회사</h3>
		</div>
	</div>
</body>
</html>