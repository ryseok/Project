<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#home2").click(function() {
			$.ajax({
				url : "/Funshop/admin_member/memberList.do",
				success : function(result) {
					$("#home").html(result);
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
	<div class="container mt-3">
		<h2>관리자 페이지</h2>
		<br>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="#" id="home2">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#menu1">Menu
					1</a></li>
			<li class="nav-item"><a class="nav-link" href="#menu2">Menu
					2</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">

			<div id="home" class="container tab-pane fade"></div>

			<div id="menu1" class="container tab-pane fade">
				<br>
				<h3>Menu 1</h3>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div id="menu2" class="container tab-pane fade">
				<br>
				<h3>Menu 2</h3>
				<p>Sed ut perspiciatis unde omnis iste natus error sit
					voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			</div>
		</div>
	</div>

	<script>
$(document).ready(function(){
    $(".nav-tabs a").click(function(){
        $(this).tab('show');
    });
});
</script>
</body>
</html>