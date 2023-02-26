let userInfo = localStorage.getItem("userInfo");
document.getElementById("appname").textContent = JSON.parse(userInfo).name;

// let logname = localStorage.getItem("namesSurnames");
let newlog = JSON.parse(userInfo).name;

let userid = JSON.parse(localStorage.getItem("userId"));

let btn = document.getElementById("submit");
btn.addEventListener("click", saveTodos);

let logout = document.getElementById("logout");
logout.addEventListener("click", logoutuser);

function saveTodos(e) {

	e.preventDefault();

	let type = document.getElementById("type");
	let content = document.getElementById("content");
	let enddate = document.getElementById("enddate");

	fetch("http://localhost:8090/todotask/post", {
		method: "POST",
		headers: {
			"Content-type": "application/json",
			"Access-Control-Allow-Origin": "http://127.0.0.1:3000"

		},
		body: JSON.stringify({
	
			userId: userid,
			title: type.value,
			content: content.value,
			dueDate: enddate.value
		})

	})
		.then(res => res.json())
		.then(data => console.log(data))

	setTimeout(() => {

		location.reload(true)

	}, "700")
		;
}

function check() {

	fetch("http://localhost:8090/todotask")
		.then(res => res.json())
		.then(data => {

			data.filter(todo => {
				if (todo.userId === userid) {

					const todoList = document.getElementById('todo-list');

					const todoItem = document.createElement('div');
					todoItem.classList.add('todo-item');

					const list = document.createElement('div');
					const type = document.createElement('input');
					const content = document.createElement('input');
					const enddate = document.createElement('input');

					const actions = document.createElement('div');
					const edit = document.createElement('button');
					edit.id = todo.id;
					const deleteButton = document.createElement('button');
					deleteButton.id = todo.id;


					list.classList.add('todo-content');
					actions.classList.add('actions');
					edit.classList.add('edit');
					deleteButton.classList.add('delete');

					type.id = "typeApp";
					content.id = "contentApp";
					enddate.id = "endddateApp";

					type.value = todo.title;
					content.value = todo.content;
					enddate.value = todo.dueDate;

					edit.innerHTML = 'Edit';
					deleteButton.innerHTML = 'Delete';

					actions.appendChild(edit);
					actions.appendChild(deleteButton);
					todoItem.appendChild(list);
					list.appendChild(type);
					list.appendChild(content);
					list.appendChild(enddate);
					todoItem.appendChild(actions);

					todoList.appendChild(todoItem);

					type.removeAttribute('readonly');
					content.removeAttribute('readonly');
					enddate.removeAttribute('readonly');

					edit.addEventListener("click", () => {

						let obj = {
							title: type.value,
							content: content.value,
							dueDate: enddate.value,
							userId: userid,
							id: todo.id
						}


						fetch(`http://localhost:8090/todotask/${edit.id}`, {
							method: "PUT",
							headers: {
								'Content-Type': 'application/json'
							},
							body: JSON.stringify(obj)
						})
							.then(res => res.json())
							.then(data => console.log(data))

					})

					deleteButton.addEventListener("click", () => {

						fetch(`http://localhost:8090/todotask/${deleteButton.id}`, {
							method: "DELETE",
							headers: {
								'Content-Type': 'application/json'
							},

						})

						setTimeout(() => {

							location.reload(true)

						}, "900");
					})
				}
			})
		})
}


check()

function logoutuser() {

	window.location.href = "http://127.0.0.1:3000/Assignment/Main/main.html";
	localStorage.removeItem("userId");
}

