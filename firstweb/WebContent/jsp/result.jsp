<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
v1 = <%=(int)request.getAttribute("v1")%> <br/>
v2 = <%=(int)request.getAttribute("v2")%> <br/>
result = <%=(int)request.getAttribute("result")%> <br/>
 --%>
 
 ${v1} + ${v2} = ${result}
</body>
</html>