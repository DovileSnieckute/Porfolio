// user id from localStorage
let userid = JSON.parse(localStorage.getItem("userId"));

// token from localStorage
let token = localStorage.getItem("token");

// save new object
let btn = document.getElementById("submit");
btn.addEventListener("click", saveObject);

function saveObject(e) {

	e.preventDefault();

	let objectNumber = document.getElementById("objectNumber");
	let objectAddress = document.getElementById("objectAddress");
	console.log(token);
	fetch("http://localhost:8090/object/post", {
		method: "POST",
		headers: {
			"Content-type": "application/json",
			"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
			"Authorization": "Bearer " + token

		},
		body: JSON.stringify({

			objectNumber: objectNumber.value,
			address: objectAddress.value,
			users: [
				{
					id: userid
				}
			]
		})

	})
		.then(res => res.json())
		.then(data => console.log(data))

	setTimeout(() => {

		location.reload(true)

	}, "700")
		;

}

// get all user objects
function check() {

	fetch("http://localhost:8090/object", {
		method: "GET",
		headers: {
			"Content-type": "application/json",
			"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
			"Authorization": "Bearer " + token
		}
	})
		.then(res => res.json())
		.then(data => {

			data.filter(object => {

				object.users.filter(user => {

					if (user.id === userid) {

						const objectList = document.getElementById('object-list');

						const objectItem = document.createElement('div');
						objectItem.classList.add('object-item');

						const list = document.createElement('div');

						const objectNumber = document.createElement('input');
						objectNumber.value = object.objectNumber;
						objectNumber.setAttribute("readonly", "true");

						const objectAddress = document.createElement('input');
						objectAddress.style.marginLeft = 4 + "rem";
						objectAddress.value = object.address;
						objectAddress.setAttribute("readonly", "true");

						const objectPlan = document.createElement('input');
						objectPlan.style.marginLeft = 3 + "rem";
						objectPlan.setAttribute("readonly", "true");

						const actions = document.createElement('div');

						const edit = document.createElement('button');
						edit.id = object.id;
						edit.innerHTML = 'Edit';

						const deleteButton = document.createElement('button');
						deleteButton.id = object.id;
						deleteButton.innerHTML = 'Delete';

						list.classList.add('object-content');
						actions.classList.add('actions');
						edit.classList.add('edit');
						deleteButton.classList.add('delete');

						actions.appendChild(edit);
						actions.appendChild(deleteButton);
						objectItem.appendChild(list);
						list.appendChild(objectNumber);
						list.appendChild(objectAddress);
						list.appendChild(objectPlan);
						objectItem.appendChild(actions);
						objectList.appendChild(objectItem);

						// get object plan title
						fetch("http://localhost:8090/plan", {
							method: "GET",
							headers: {
								"Content-type": "application/json",
								"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
								"Authorization": "Bearer " + token
							}
						})
							.then(res => res.json())
							.then(data => {

								data.filter(plan => {

									if (plan.id == object.planId) {
										objectPlan.value = plan.title

									}

								})

							})



						document.getElementById("header").style.visibility = "visible";


						// edit button
						edit.addEventListener("click", () => {

							document.getElementById('id02').style.visibility = "visible";

							document.getElementById("objNumber").value = objectNumber.value;
							document.getElementById("objAddress").value = objectAddress.value;
							document.getElementById("objPlan").value = objectPlan.value;
							document.getElementById("objPlan").setAttribute("readonly", "true");

							let saveChanges = document.getElementById("saveBtn");

							saveChanges.addEventListener("click", async () => {

								document.getElementById('id02').style.visibility = "hidden";

								let obj = {
									objectNumber: document.getElementById("objNumber").value,
									address: document.getElementById("objAddress").value,
									users: [
										{
											id: userid
										}
									],
									planId: object.planId

								}

								await fetch(`http://localhost:8090/object/${edit.id}`, {
									method: "PUT",
									headers: {
										"Content-type": "application/json",
										"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
										"Authorization": "Bearer " + token
									},
									body: JSON.stringify(obj)
								})
									.then(res => res.json())
									.then(data => console.log(data))


								objectNumber.value = document.getElementById("objNumber").value;
								objectAddress.value = document.getElementById("objAddress").value;
								objectPlan.value = document.getElementById("objPlan").value;


								setTimeout(() => {

									location.reload(true)
	
								}, "900");

							})
							
						})


						// delete button
						deleteButton.addEventListener("click", () => {

							fetch(`http://localhost:8090/object/${deleteButton.id}`, {
								method: "DELETE",
								headers: {
									"Content-type": "application/json",
									"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
									"Authorization": "Bearer " + token
								},

							})

							setTimeout(() => {

								location.reload(true)

							}, "900");
						})
					}
				})
			})
		})

}


check()

// logout
let logout = document.getElementById("logout");
logout.addEventListener("click", logoutuser);

function logoutuser() {

	window.location.href = "http://127.0.0.1:3000/Final/Main/main.html";
	localStorage.removeItem("userId");
	localStorage.removeItem("userInfo");
	localStorage.removeItem("userRole");
	localStorage.removeItem("token");
}

// ref to main page
let logo = document.getElementById("logo");
let logo2 = document.getElementById("logo2");

logo.addEventListener("click", refToMain);
logo2.addEventListener("click", refToMain);

function refToMain() {

	window.location.href = "http://127.0.0.1:3000/Final/Object/myObject.html";

}


//save user role to localStorage
function saveRole() {
	fetch("http://localhost:8090/user", {
		method: "GET",
		headers: {
			"Content-type": "application/json",
			"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
			"Authorization": "Bearer " + token
		}


	})
		.then(res => res.json())
		.then(data => {


			data.filter(user => {


				if (user.id == userid) {

					localStorage.setItem("userRole", user.role);

				}

			})

		})

}

saveRole();