var updateButtons = document.querySelectorAll('.update_button');

for(var i=0; i<updateButtons.length; i++) {
	updateButtons[i].addEventListener("click", function (e) {
		var parentElement = e.target.parentElement;
		var buttonElement = e.target;
		var data = {
				type: buttonElement.getAttribute("data-type")
			};
		var xhr = new XMLHttpRequest();
		
		xhr.addEventListener("load", function() {
			if (xhr.status == "200" && xhr.responseText === "success") {
				var currentType = buttonElement.getAttribute("data-type");
				var currentList = document.querySelector('.' + getCurrentParentClassName(currentType));
				var nextList = document.querySelector('.' + getNextParentClassName(currentType));
				currentList.removeChild(parentElement);
				nextList.appendChild(parentElement)
				
				if(nextList.getAttribute("Class") === "done_list") {
					parentElement.removeChild(buttonElement);
				}
				buttonElement.setAttribute("data-type", getNextTodoType(currentType));
			}
		});    
		
		xhr.open("PUT", "/todo/todos/" + buttonElement.getAttribute("data-id"));
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(JSON.stringify(data));
	});
}

function getCurrentParentClassName(currentType) {
	return currentType.toLowerCase() + '_list';
}

function getNextParentClassName(currentType) {
	switch(currentType) {
	case "TODO":
		return "doing_list"
	case "DOING":
		return "done_list";
	}
}

function getNextTodoType(currentType) {
	switch(currentType) {
	case "TODO":
		return "DOING"
	case "DOING":
		return "DONE";
	}
}