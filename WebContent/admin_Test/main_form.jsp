<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript">
    $(function(){
    	$('a[name=member]').click(function(){
    		$.ajax({
    			url:'/Funshop/admin_member/memberList.do',
    			success:function(result){
    				$('td#content').html(result);
    			}
    		});
    	});
    });
  </script>
<title>Insert title here</title>
</head>
<body>
<!-- 테이블만들기 -->
		<table border=1 width=800 height=600>
			<tr height=10%> <!-- 전체를 3등분이아니라 위아래는 좁게 가운대는 넓게 유동적으로 하기위해서 -->
				<td colspan=2 align="center">
					<a href="main_form.jsp">main</a>|
					로그인|
					회원가입|
					<a href="/Funshop/admin_member/memberList.do">회사소개</a>
				</td>
			</tr>
			<tr height=80%>
				<td width=15%>tree/view 메세지</td>
				<td width=85% id="content">
					<h2>저희 홈페이지에 오신것을 환영합니다.</h2>
					<ul>
						<!-- <li><a href="/Funshop/admin_member/memberList.do" name="member">기본관리페이지</a></li> -->
						 <li><a href="#" name="member">기본관리페이지</a></li> 
					</ul>
				</td>
			</tr>
			<tr height=10%>
				<td colspan=2 align="center">
					회사규약
				</td>
			</tr>	
		</table>
</body>
</html>