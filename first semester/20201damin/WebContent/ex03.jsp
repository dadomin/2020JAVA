<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 사용하기</title>
</head>
<body>
	<h1>변수</h1>
	<%
	String name = "김다민";
	%>
	
	이름 : name <br />
	이름 : <%= name %>
	
	<h1>조건문</h1>
	<%
		if(name == "박민지"){
			name = "틀리다";
		}else {
			name = "맞다"; 
		}
	
	%>
	
	이름 : <%= name %>
	
	<h1>반복문</h1>
	<%
	
	%>

</body>
</html>