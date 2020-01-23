window.onload = function() {
	function getCurrentListClassName(currentType) {
		return `${currentType.toLowerCase()}_list`;
	}

	function getNextListClassName(currentType) {
		switch (currentType) {
		case "TODO":
			return "doing_list"
		case "DOING":
			return "done_list";
		default:
			return undefined;
		}
	}

	function getNextTodoType(currentType) {
		switch (currentType) {
		case "TODO":
			return "DOING"
		case "DOING":
			return "DONE";
		default:
			return undefined;
		}
	}

	function moveTodoItem(todoItem, updateButton) {
		const currentType = updateButton.dataset.todoType
		const currentList = document.querySelector(`.${getCurrentListClassName(currentType)}`);
		const nextList = document.querySelector(`.${getNextListClassName(currentType)}`);

		if (currentList && nextList) {
			currentList.removeChild(todoItem);
			nextList.appendChild(todoItem);
		} else {
			window.location.href = "/todo/main";
		}

		var nextType = getNextTodoType(currentType);
		if (nextType === "DONE") {
			todoItem.removeChild(updateButton);
		} else if (!nextType) {
			window.location.href = "/todo/main";
		}

		updateButton.dataset.todoType = nextType;
	}

	const todoListWrapper = document.querySelector(".todo_list_wrap");

	todoListWrapper.addEventListener("click", function(event) {
		if (event.target.className !== "update_button") {
			return;
		}

		const todoItem = event.target.parentElement;
		const updateButton = event.target;
		const data = {
			type : updateButton.dataset.todoType
		};
		const xhr = new XMLHttpRequest();

		xhr.addEventListener("load", function() {
			if (xhr.status !== 200 || xhr.responseText !== "success") {
				if (xhr.responseText) {
					alert(xhr.responseText);
				} else {
					alert("서버 오류입니다.");
				}
				return;
			}

			moveTodoItem(todoItem, updateButton);
		});

		xhr.open("PUT", `/todo/todos/${updateButton.dataset.todoId}`);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(JSON.stringify(data));
	});

}
