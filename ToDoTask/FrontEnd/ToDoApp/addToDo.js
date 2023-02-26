
let userInfo = localStorage.getItem("userInfo");
document.getElementById("appname").textContent = JSON.parse(userInfo).name;

let addToDo = document.getElementById("addBtn");
addToDo.addEventListener("click", openToDo);

let logout = document.getElementById("logout");
logout.addEventListener("click", logoutuser);

function openToDo(e){

    e.preventDefault();

    window.location.href = "http://127.0.0.1:3000/Assignment/ToDoApp/toDoApp.html";
}

function logoutuser() {

	window.location.href = "http://127.0.0.1:3000/Assignment/Main/main.html"
}