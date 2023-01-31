// get user id from localStorage
let userid = JSON.parse(localStorage.getItem("userId"));

// get token from localStorage
let token = localStorage.getItem("token");

// logout
let logout = document.getElementById("logout");
logout.addEventListener("click", logoutuser);

function logoutuser() {

	window.location.href = "http://127.0.0.1:3000/Final/Main/main.html";
	localStorage.removeItem("userId");
}

// get all plans
function showPlans() {
	

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


				const modal = document.getElementById("allPlans")
				const id02 = document.createElement('div');
				id02.id = "id02";
				const myForm = document.createElement('form')
				myForm.id = "myForm";
				const myDiv = document.createElement('div');
				myDiv.id = "container2";
				const planSupplier = document.createElement('h2');
				planSupplier.id = "supplier";
				const planName = document.createElement('p');
				planName.id = "planName";
				const period = document.createElement('p');
				period.id = "period";
				const fixedPeriod = document.createElement('p');
				fixedPeriod.id = "fixedPeriod";
				const startDate = document.createElement('p');
				startDate.id = "startDate";
				const timeZone = document.createElement('p');
				timeZone.id = "timeZone";
				const energyType = document.createElement('p');
				energyType.id = "energyType";
				const price = document.createElement('p');
				price.id = "price";

				const chooseBtn = document.createElement('div');
				const deleteBtn = document.createElement('button');
				const editBtn = document.createElement('div');



				editBtn.id = plan.id;
				editBtn.textContent = "Edit Plan"
				editBtn.style.visibility = "hidden"

				deleteBtn.id = plan.id;
				deleteBtn.textContent = "Delete Plan"
				deleteBtn.style.visibility = "hidden"


				chooseBtn.id = plan.id;
				chooseBtn.textContent = "Choose Plan";

				myDiv.append(planSupplier, planName, period, fixedPeriod, startDate, timeZone, energyType, price, chooseBtn, editBtn, deleteBtn)
				myForm.append(myDiv);
				id02.append(myForm);
				modal.append(id02);


				planName.textContent = "Plan name: " + plan.title;
				period.textContent = "Agreement validity term: " + plan.period + " months";
				fixedPeriod.textContent = "Price fixing term: " + plan.fixedPeriod + " months";
				startDate.textContent = "Supply start date: " + plan.startDate;
				timeZone.textContent = "Plan type: " + plan.timeZone;
				energyType.textContent = "Type of energy: " + plan.energyType;
				price.textContent = "Price: " + plan.price + " Eur/kWh";


				// user role
				let userRole = localStorage.getItem("userRole");

				if (userRole == "ROLE_ADMIN") {
					deleteBtn.style.visibility = "visible"
					editBtn.style.visibility = "visible"
					myDiv.style.height = 700 + "px"
					document.getElementById("createPlan").style.visibility = "visible"
					document.getElementById("createPlan").style.marginLeft = 20 + "px"

					document.getElementById("createSupplier").style.visibility = "visible"
					document.getElementById("createSupplier").style.marginLeft = 30 + "px"


				}

				// get supplier name
				fetch("http://localhost:8090/supplier", {
					method: "GET",
					headers: {
						"Content-type": "application/json",
						"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
						"Authorization": "Bearer " + token
					}
				})
					.then(res => res.json())
					.then(data => {

						data.filter(supplier => {

							if (supplier.id == plan.supplierId) {
								planSupplier.textContent = supplier.name

							}

						})

					})


				// delete button
				deleteBtn.addEventListener("click", () => {

					fetch(`http://localhost:8090/plan/${deleteBtn.id}`, {
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

					showPlans();
				})




				// edit button
				editBtn.addEventListener("click", () => {

					document.getElementById("id04").style.visibility = "visible";

					document.getElementById("planName1").value = plan.title;
					document.getElementById("period1").value = plan.period;
					document.getElementById("fixedPeriod1").value = plan.fixedPeriod;
					document.getElementById("startDate1").value = plan.startDate;
					document.getElementById("timeZone1").value = plan.timeZone;
					document.getElementById("energyType1").value = plan.energyType;
					document.getElementById("price1").value = plan.price;
					document.getElementById("supplierChange").textContent = planSupplier.textContent;

					document.getElementById("saveChanges").addEventListener("click", () => {

						document.getElementById("id04").style.visibility = "hidden";

						let newPlan = {

							id: editBtn.id,
							title: document.getElementById("planName1").value,
							period: document.getElementById("period1").value,
							fixedPeriod: document.getElementById("fixedPeriod1").value,
							startDate: document.getElementById("startDate1").value,
							timeZone: document.getElementById("timeZone1").value,
							energyType: document.getElementById("energyType1").value,
							price: document.getElementById("price1").value,
							supplierId: plan.supplierId


						}


						fetch(`http://localhost:8090/plan/${editBtn.id}`, {
							method: "PUT",
							headers: {
								"Content-type": "application/json",
								"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
								"Authorization": "Bearer " + token
							},
							body: JSON.stringify(newPlan)
						})
							.then(res => res.json())
							.then(data => console.log(data))

						planName.textContent = "Plan name: " + document.getElementById("planName1").value;
						period.textContent = "Agreement validity term: " + document.getElementById("period1").value + " months";
						fixedPeriod.textContent = "Price fixing term: " + document.getElementById("fixedPeriod1").value + " months";
						startDate.textContent = "Supply start date: " + document.getElementById("startDate1").value;
						timeZone.textContent = "Plan type: " + document.getElementById("timeZone1").value;
						energyType.textContent = "Type of energy: " + document.getElementById("energyType1").value;
						price.textContent = "Price: " + document.getElementById("planName1").value + " Eur/kWh";
						planSupplier.textContent = document.getElementById("supplierChange").textContent;

					})

				})






				// add plan to object
				chooseBtn.addEventListener("click", async () => {

					document.getElementById("id03").style.visibility = "visible";



					await fetch("http://localhost:8090/object", {
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

										const dropdown = document.getElementById("dropbtn");

										const myObject = document.createElement('option');

										dropdown.append(myObject);

										myObject.textContent = object.objectNumber;

									}



									document.getElementById("addObjToPlan").addEventListener("click", async () => {

										const dropdown = document.getElementById("dropbtn");

										for (let i = 0; i < data.length; i++) {

											if (dropdown.value == data[i].objectNumber) {

												document.getElementById("id03").style.visibility = "hidden";

												let objId = data[i].id;

												console.log(objId)
												let objPlan = {

													address: data[i].address,
													objectNumber: data[i].objectNumber,
													planId: chooseBtn.id,
													users: [
														{
															id: userid
														}
													]
												}
												fetch(`http://localhost:8090/object/${objId}`, {
													method: "PUT",
													headers: {
														"Content-type": "application/json",
														"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
														"Authorization": "Bearer " + token
													},
													body: JSON.stringify(objPlan)
												})
													.then(res => res.json())
													.then(data => console.log(data))

											}
										}

									})

								})

							})
						})

				})

			})

		})

}

showPlans();


// create new plan
let createBtn = document.getElementById("createPlan");
createBtn.addEventListener("click", createNewPlan);

function createNewPlan(e) {

	e.preventDefault();

	document.getElementById("id05").style.visibility = "visible";

	let planName = document.getElementById("planName2");
	let period = document.getElementById("period2");
	let fixed = document.getElementById("fixedPeriod2");
	let startDate = document.getElementById("startDate2");
	let timeZone = document.getElementById("timeZone2");
	let energyType = document.getElementById("energyType2");
	let price = document.getElementById("price2");


	fetch("http://localhost:8090/supplier", {
		method: "GET",
		headers: {
			"Content-type": "application/json",
			"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
			"Authorization": "Bearer " + token
		}


	})
		.then(res => res.json())
		.then(data => {


			data.filter(supplier => {


				const dropdown = document.getElementById("planSupplier");

				const mySupplier = document.createElement('option');

				dropdown.append(mySupplier);

				mySupplier.textContent = supplier.name;

				mySupplier.id = supplier.id;


			})

			document.getElementById("savePlan").addEventListener("click", () => {

				let dropDownValue = document.getElementById("planSupplier");


				for (let i = 0; i < data.length; i++) {

					if (dropDownValue.value == data[i].name) {

						document.getElementById("id05").style.visibility = "hidden";

						let supplierPlanId = data[i].id;

						console.log(supplierPlanId)


						// post new plan to database
						fetch("http://localhost:8090/plan/post", {
							method: "POST",
							headers: {
								"Content-type": "application/json",
								"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
								"Authorization": "Bearer " + token

							},
							body: JSON.stringify({


								title: planName.value,
								period: period.value,
								fixedPeriod: fixed.value,
								startDate: startDate.value,
								timeZone: timeZone.value,
								energyType: energyType.value,
								price: price.value,
								supplierId: supplierPlanId

							})

						})
							.then(res => res.json())
							.then(data => console.log(data))

						setTimeout(() => {

							location.reload(true)

						}, "900")
							;

						
					}
				}

			})

		})


}


// create new supplier
let createSupplier = document.getElementById("createSupplier");
createSupplier.addEventListener("click", createNewSupplier)

function createNewSupplier(e) {

	e.preventDefault();

	document.getElementById("id06").style.visibility = "visible";

	document.getElementById("saveSupplier").addEventListener("click", () => {


		fetch("http://localhost:8090/supplier/post", {
			method: "POST",
			headers: {
				"Content-type": "application/json",
				"Access-Control-Allow-Origin": "http://127.0.0.1:3000",
				"Authorization": "Bearer " + token

			},
			body: JSON.stringify({

				name: document.getElementById("supplierName").value


			})

		})
			.then(res => res.json())
			.then(data => console.log(data))

		setTimeout(() => {

			location.reload(true)

		}, "900")
			;

	})
}


// ref to main page
let logo = document.getElementById("logo");
let logo2 = document.getElementById("logo2");

logo.addEventListener("click", refToMain);
logo2.addEventListener("click", refToMain);

function refToMain() {

	window.location.href = "http://127.0.0.1:3000/Final/Object/myObject.html";

}







