<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본태그 1</title>
</head>
<body>

<!-- html 태그 -->
<h1> Hello 김다민 </h1>

<!-- 스크립트릿 태그 -->
<%
int num1 = 20;
int num2 = 10;
int add = num1 * num2;
out.print( num1 + " * " + num2 + " = " + add);
%>
<hr>
<!-- 선언태그 : 변수의 범위 -->
<%! int global_cnt = 10; %>
<% 
int local_cnt = 0; 
out.print("<br> local_cnt : ");
out.print(++local_cnt);
out.print("<br> global_cnt : ");
out.print(global_cnt);
%>
<hr>
<!-- 선언태그 : 메서드 호출과 멤버변수 -->
<%!
String str = "안녕하세요!";
int a = 5, b = -5;

public int abs(int n) {
	if( n < 0 ) n = -n;
	return n;
}
%>
<h3> 스크립트릿 태그로 출력 </h3>
<%
out.print(str + "<br>");
out.print(a + "의 절댓값 : " + abs(a) + "<br>");
%>
<h3> 익스프레션 태그로 출력 </h3>
<%= str %><br>
<%= b %>의 절댓값 : <%= abs(b) %>

</body>
</html>