<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1" cellpadding="5" width="100%">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>휴대폰 번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>가입 날짜</th>
			<th>수정 및 삭제</th>
		</tr>
	</thead>
	<tbody id="tbody">
		<c:forEach items="${list }" var="member">
			<tr>
				<td>${member.no }</td>
				<td>${member.id }</td>
				<td>${member.pass }</td>
				<td>${member.name }</td>
				<td>${member.tel }</td>
				<td>${member.email }</td>
				<td>${member.addr }</td>
				<td>${member.wdate }</td>
				<td>
				<button onclick="passCheck('up')">수정</button>
				<button onclick="passCheck('del')">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>