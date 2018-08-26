<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/Funshop/image/favicon.ico">
 <script type="text/javascript">
    	$(function(){
    		if("${id}"=="admin") {
    			$("#productEnroll").show();
    		}
    		 $("input#mainSearch").keyup(function()   {
                 var mainSearch = $(this).val();
                 if(mainSearch=='') { 
                     $("#display").hide();
                 } else {    
                     $.ajax({
                     url: "/Funshop/mainPage.do?action=search",
                     data: {mainSearch : mainSearch},
                     success:function(result){
                    	   // alert(result);
							var words = result.split("|");
							var count = words[0];
							if(count>0){
 								$("#display").text("");
							$.each(words[1].split(','),function(index, value){
								$("#display").append($("<a href=\"javascript:select('"+
			                 			   value+"')\">"+value+"</a><br>").text(value)).show();
							})
							}
						}
                     });
                 }
             });     
         });
    	
    	function logout() {
    		alert('로그아웃 되었습니다.');
    		location.replace('/Funshop/login.do?action=logout');
    	}
    </script>       
</head>
<body>
 <!-- Navigation -->
    <nav class="navbar navbar-light bg-light fixed-top" >
      <div class="container">
      	<input type="hidden"  id="page-top">
        <a class="navbar-brand" href="/Funshop/mainPage/main.do">Funshop</a>
        <input type="text"  placeholder="어떤 재미를 원하시나요?" id="mainSearch">
         <a class="btn btn-primary" href="#">찾기</a>
         <a class="btn btn-primary" href="/Funshop/myPage/main.do">마이페이지</a>
         <c:if test="${id == null}">
          	<a class="btn btn-primary" href="/Funshop/login.do">로그인</a>
         </c:if>
         <c:if test="${id != null}">
          	<a class="btn btn-primary" href="javascript:logout();">로그아웃</a>
         </c:if>
        <a class="btn btn-primary" href="/Funshop/adminPage/regProductForm.do" style="display: none" id="productEnroll">물품등록</a>
      </div><br>
        <div id="display"  style="position: absolute;left: 400px;top: 50px; background-color: white"></div>
      <div class="container">
        <a class="navbar-brand" href="#">베스트</a>
        <a class="navbar-brand" href="#">신규상품</a>
        <a class="navbar-brand" href="/Funshop/mainPage/review.do">후기</a>
        <a class="navbar-brand" href="/Funshop/mainPage/event.do">Event</a>
      </div>
    </nav>
</body>
</html>