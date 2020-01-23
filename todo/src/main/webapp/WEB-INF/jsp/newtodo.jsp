<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW TODO</title>
<link rel="stylesheet" href="/todo/css/layout.css" />
<link rel="stylesheet" href="/todo/css/newtodo.css" />
</head>
<body>
<div class="wrap">
	<header>
		<h2 class="header_title">할일 등록</h2>
	</header>

	<main>
		<section class="new_todo_wrap">
			<form action="/todo/todos" method="post" accept-charset="UTF-8">
				<article class="question_wrap">
					<p class="question_description">어떤일인가요?</p>
					<input type="text" class="title" name="title" placeholder="swift 공부하기(24자까지)" 
						maxlength="24" required/>
				</article>
				<article class="question_wrap">
					<p class="question_description">누가 할일인가요?</p>
					<input type="text" class="name" name="name" placeholder="홍길동" maxlength="15" required/>
				</article>
				<article class="question_wrap">
					<p class="question_description">우선순위를 선택하세요</p>
					<label class="radio_button">
						<input type="radio" name="sequence" class="sequence" value="1" required/>1순위
					</label>
					<label class="radio_button">
						<input type="radio" name="sequence" class="sequence" value="2" required/>2순위
					</label>
					<label class="radio_button">
						<input type="radio" name="sequence" class="sequence" value="3" required/>3순위
					</label>
				</article>
				<article class="button_wrap">
					<a href="/todo/main"><button id="prev_button" type="button">&lt; 이전</button></a>
					<button id="submit_button" type="submit">제출</button>
					<button id="reset_button" type="reset">내용지우기</button>
				</article>
			</form>
		</section>
	</main>
</div>
</body>
</html>