<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본태그2</title>
</head>
<body>

<h3>멤버 변수 가져와서 출력하기</h3>
<%!
String name = "김다민";
public String getName(){
	return name;
}
%>

<!-- 스크립트릿 태그 -->
<%
for( int i = 1; i <= 3; i++ ){
	out.print(i + " : " + getName() + "<br>");
}
%>

<hr>

<!-- 지시자(디렉티브 tag) import -->
<h3> 지시자(디렉티브 tag) import </h3>
<%
Calendar date = Calendar.getInstance();
SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초"); 
%>
오늘은 <b> <%= today.format(date.getTime()) %> </b> 입니다. <br>
지금 시각은 <b> <%= now.format(date.getTime()) %> </b> 입니다.

<hr>

<!-- 지시자(디렉티브 tag) include --> 
<h3> 지시자(디렉티브 tag) include </h3>
<a href="sub.jsp"> 서브 페이지로 이동하기 </a> <br>
<%@ include file = "footer.jsp" %>

</body>
</html>