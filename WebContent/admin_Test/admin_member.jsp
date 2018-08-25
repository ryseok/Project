<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자</title>
<script type="text/javascript" src="../jQuery_js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#search").keyup(function() {
			var txt = $(this).val().toUpperCase();
			$('#tbody tr').filter(function() {
				$(this).toggle($(this).text().toUpperCase().indexOf(txt) > -1);
			});

		});
		$.ajax({
			url : "/Funshop/admin.do",
			data : {
				search : $("#search").val()
			},
			success : function(result) {
				$("div").html(result);
			}
		}); //ajax
	}); //document ready
</script>
<script type="text/javascript">

</script>
</head>
<body>
	<h1>회원정보</h1>
	<hr>
	<input type="text" name="keyword" id="search">
	<br><br>
	<!-- 회원정보 목록 출력(DB에 저장된 값을 화면에 출력) -->
	<div></div>
</body>
</html>