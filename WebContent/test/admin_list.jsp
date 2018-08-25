<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과 페이지2</title>
</head>
<body>
	<h3>결과 페이지(파일 업로드)</h3>
	<hr>
	<%
		String saveDir=application.getRealPath("/upload"); //저정할 폴더 정보
		//===> c:rys/workspace/TomTest/upload
		
		int maxSize=5*1024*1024; //업로드 될 파일의 크리 제한, 단위 : byte
		//5 5byte*1024 5kb*1024 5mkb
		
		String encType = "UTF-8";
		
		MultipartRequest  mreq = new MultipartRequest(request,saveDir,maxSize,new DefaultFileRenamePolicy());
		out.print("파일 업로드 성공 ");
	%>
	<br>
	원본 파일명 : <%= mreq.getOriginalFileName("myfile") %>
	<br>	
	저장 파일명 : <%= mreq.getFilesystemName("myfile") %>
	
	<%-- <img  src="/Funshop/upload/<%= mreq.getFilesystemName("myfile") %>" width="300" height="400"> --%>
	
</body>
</html>