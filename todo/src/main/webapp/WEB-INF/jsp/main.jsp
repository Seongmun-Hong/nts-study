<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO LIST</title>
<link rel="stylesheet" href="/todo/css/layout.css" />
<link rel="stylesheet" href="/todo/css/main.css" />
</head>
<body>
<div class="wrap">
	<header>
		<nav class="header_nav">
			<div class="title_wrap">
				<span class="header_title">나의 해야 할일들</span>
			</div>
			<div class="newtodo_link_wrap">
				<a href="/todo/new" class="newtodo_link">새로운 TODO 등록</a>
			</div>
		</nav>
	</header>

	<main class="main_wrap">
		<section class="todo_list_wrap">
			<article class="todo_list">
				<div class="todo_list_title">
					TODO
				</div>
				<c:forEach items="${todoList}" var="todo">
					<div class="todo_item">
						<p class="todo_title">
							${todo.title}
						</p>
						<p class="todo_description">
							등록날짜:${todo.getFormattedRegistrationDate()}, ${todo.name}, 우선순위 ${todo.sequence}
						</p>
						<div class="update_button" data-todo-id="${todo.id}" data-todo-type="${todo.type}">
							→
						</div>
					</div>
				</c:forEach>
			</article>

			<article class="doing_list">
				<div class="todo_list_title">
					DOING
				</div>
				<c:forEach items="${doingList}" var="doing">
					<div class="todo_item">
						<p class="todo_title">
							${doing.title}
						</p>
						<p class="todo_description">
							등록날짜:${doing.getFormattedRegistrationDate()}, ${doing.name}, 우선순위 ${doing.sequence}
						</p>
						<div class="update_button" data-todo-id="${doing.id}" data-todo-type="${doing.type}">
							→
						</div>
					</div>
				</c:forEach> 
			</article>

			<article class="done_list">
				<div class="todo_list_title">
					DONE
				</div>
				<c:forEach items="${doneList}" var="done">
					<div class="todo_item">
						<p class="todo_title">
							${done.title}
						</p>
						<p class="todo_description">
							등록날짜:${done.getFormattedRegistrationDate()}, ${done.name}, 우선순위 ${done.sequence}
						</p>
					</div>
				</c:forEach>
			</article>
		</section>
	</main>
</div>
</body>
<script src="/todo/js/main.js"></script>
</html>