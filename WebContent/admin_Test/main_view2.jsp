<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 : 메인페이지</title>
<style type="text/css">
div {
	font-size: 80pt;
}
</style>
</head>
<body>
	<br><br><br><br><br>
	<table border="1" cellpadding="5" align="center">
		<tr>
			<td><a href="/Funshop/admin_member/memberList.do">회원정보 관리</a></td>
			<td><a href="/Funshop/admin_notice/noticeList.do">공지사항</a></td>
			<td><a href="/Funshop/admin_sales/sales.do">매출현황</a></td>
		</tr>

		<tr>
			<td colspan="3" id="admin_list">
				<div>
					관리자 <br> 페이지 입니다.
				</div>
			</td>
		</tr>

		<tr>
			<td colspan="3">&#169;Funshop 주식회사</td>
		</tr>
	</table>
</body>
</html>