<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <% request.setAttribute("n", 10); %> --%>
<c:set var="n" scope="request" value="10"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:if test="${n == 0}">
	n�� 0�� �����ϴ�.
</c:if>

<c:if test="${n == 10}">
	n�� 10�� �����ϴ�.
</c:if>

</body>
</html>