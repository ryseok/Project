<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#member").click(function() {
			$.ajax({
				url : "/Funshop/admin_member/memberList.do",
				success : function(result) {
					$("#admin_list div").html(result);
				}
			});
		});

		$("#notice").click(function() {
			$.ajax({
				url : "/Funshop/admin_notice/noticeList.do",
				success : function(result) {
					$("#admin_list div").html(result);
				}
			});
		});

	});
</script>
<title>Funshop_메인 페이지</title>
</head>
<body>
	<table border="1" cellpadding="5" align="center">
		<tr>
			<td><a href="/Funshop/admin_main/main_page.jsp">홈</a></td>
			<td><a href="#" id="member">회원정보 관리</a></td>
			<td><a href="#" id="notice">공지사항</a></td>
		</tr>
		
		<tr>
			<td colspan="3" id="admin_list">
				<div>관리자 <br> 페이지 입니다.</div>
			</td>
		</tr>
		
		<tr>
			<td colspan="3">&#169;Funshop 주식회사</td>
		</tr>
	</table>
</body>
</html>