<%@page import="java.util.ArrayList"%>
<%@page import="com.naver.todo.dto.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<Todo> fullList = (List<Todo>)request.getAttribute("todoList");
	List<Todo> todoTypeList = new ArrayList<>();
	List<Todo> doingTypeList = new ArrayList<>();
	List<Todo> doneTypeList = new ArrayList<>();
	
	for(int i=0, len = fullList.size(); i<len; i++) {
		switch(fullList.get(i).getType()) {
			case "TODO":
				todoTypeList.add(fullList.get(i));
				break;
			case "DOING":
				doingTypeList.add(fullList.get(i));
				break;
			case "DONE":
				doneTypeList.add(fullList.get(i));
				break;
		}
	}
	request.setAttribute("todoTypeList", todoTypeList);
	request.setAttribute("doingTypeList", doingTypeList);
	request.setAttribute("doneTypeList", doneTypeList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO LIST</title>
<link rel="stylesheet" href="/todo/css/layout.css" />
<link rel="stylesheet" href="/todo/css/main.css" />
</head>
<body>
<header>
	<nav class="header_nav">
		<div class="title_wrap">
			<span class="header_title">나의 해야 할일들</span>
		</div>
		<div class="newtodo_link_wrap">
			<a href="/todo/jsp/newtodo.jsp" class="newtodo_link">새로운 TODO 등록</a>
		</div>
	</nav>
</header>
<main class="main_wrap">
	<section class="todo_list_wrap">
		<article class="todo_list">
			<div class="todo_title">
				TODO
			</div>
			<c:forEach items="${todoTypeList}" var="item">
				<div class="todo_item">
					<p class="item_title"><c:out value="${item.title}" /></p>
					<p class="item_description">등록날짜:${item.regDate}, ${item.name}, 우선순위 ${item.sequence}</p>
					<div class="update_button" data-id="${item.id}" data-type="${item.type}">→</div>
				</div>
			</c:forEach>
		</article>
		<article class="doing_list">
			<div class="doing_title">
				DOING
			</div>
			<c:forEach items="${doingTypeList}" var="item">
				<div class="todo_item">
					<p class="item_title"><c:out value="${item.title}" /></p>
					<p class="item_description">등록날짜:${item.regDate}, ${item.name}, 우선순위 ${item.sequence}</p>
					<div class="update_button" data-id="${item.id}" data-type="${item.type}">→</div>
				</div>
			</c:forEach> 
		</article>
		<article class="done_list">
			<div class="done_title">
				DONE
			</div>
			<c:forEach items="${doneTypeList}" var="item">
				<div class="todo_item">
					<p class="item_title"><c:out value="${item.title}" /></p>
					<p class="item_description" data-id="${item.id}">등록날짜:${item.regDate}, ${item.name}, 우선순위 ${item.sequence}</p>
				</div>
			</c:forEach>

		</article>
	</section>
</main>
</body>
<script src="/todo/js/main.js"></script>
</html>