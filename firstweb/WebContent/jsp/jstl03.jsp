<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" scope="request" value="55"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${score >= 90}">
		A���� �Դϴ�.
	</c:when>
	<c:when test="${score >= 80}">
		B���� �Դϴ�.
	</c:when>
	<c:when test="${score >= 70}">
		C���� �Դϴ�.
	</c:when>
	<c:when test="${score >= 60}">
		D���� �Դϴ�.
	</c:when>
	<c:otherwise>
		F���� �Դϴ�.
	</c:otherwise>
	
</c:choose>

</body>
</html>