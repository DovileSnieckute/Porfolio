//lamp turn on/off
var btn = document.getElementById("btn");

var light = document.getElementById("light");

let words = document.getElementById("words");
let words2 = document.getElementById("words2");

function toggleBtn() {
  btn.classList.toggle("active");
  light.classList.toggle("on")
  if (words.style.display === "none" && words2.style.display) {
    words.style.display = "block";
    words2.style.display = "block";

  } else {
    words.style.display = "none";
    words2.style.display = "none";

  }
}

//signup / login

let signupBtn = document.getElementById("signupBtn");
let loginBtn = document.getElementById("loginBtn");

let signupName = document.getElementById("name2");
let signupSurname = document.getElementById("surname2");
let signupEmail = document.getElementById("email2");
let signupPassword = document.getElementById("password2");
let repeatPassword = document.getElementById("repeatPassword");
let error = document.getElementById("error");
let passwordError = document.getElementById("passwordError");

let loginEmail = document.getElementById("email");
let loginPassword = document.getElementById("password");
let errorLogin = document.getElementById("errorLogin");


signupBtn.addEventListener("click", saveData);
loginBtn.addEventListener("click", loginData);



// find user by email in database
async function fetchUser() {

  let flag = true;
  await fetch("http://localhost:8090/user")
    .then(res => res.json())
    .then(data => {
      for (let i = 0; i < data.length && flag; i++) {

        if (data[i].email === signupEmail.value) {
          error.textContent = "User already exists";
          error.style.visibility = "visible";
          flag = false;
        }
        else if (signupPassword.value != repeatPassword.value) {
          passwordError.textContent = "Passwords do not match";
          passwordError.style.visibility = "visible";
          flag = false;
        }

      }
      return flag
    })
  return flag
}


// signup new user
function saveData(e) {

  e.preventDefault();

  fetchUser()
    .then(exist => {

      if (exist) {
        fetch("http://localhost:8090/api/auth/signup", {
          method: "POST",
          headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin": "http://127.0.0.1:3000"
          },

          body: JSON.stringify({
            name: signupName.value,
            surname: signupSurname.value,
            email: signupEmail.value,
            password: signupPassword.value,
            repeatPassword: repeatPassword.value

          })

        })
          .then(res => res.json())
          .then(data => {

            const userData = {
              "name": signupName.value,
              "surname": signupSurname.value
            }

            localStorage.setItem("userInfo", JSON.stringify(userData));
            localStorage.setItem("userId", data.id);


            window.location.href = "http://127.0.0.1:3000/Final/Object/myObject.html"

          })
      }
    })
}

// login user
function loginData(e) {

  e.preventDefault();

  let myToken = "";

  fetch(`http://localhost:8090/api/auth/login`, {

    method: `POST`,
    headers: {

      'Content-Type': 'application/json'
    },

    body: JSON.stringify({ email: loginEmail.value, password: loginPassword.value })


  })
    .then(res => {
      myToken = res.headers.get("Authorization");

      if (res.status == 200) {

        res.json()
          .then(user => {

            console.log(user);

            const userInfo = {
              email: loginEmail.value,


            }

            localStorage.setItem("userInfo", JSON.stringify(userInfo));

            localStorage.setItem("userId", user.id);

            localStorage.setItem("token", myToken)

            window.location.href = "http://127.0.0.1:3000/Final/Object/myObject.html"

          })
      }
      else {
        errorLogin.textContent = "User not found";
        errorLogin.style.visibility = "visible";
      }
    })
}


// ref to main page
let logo = document.getElementById("logo");
let logo2 = document.getElementById("logo2");

logo.addEventListener("click", refToMain);
logo2.addEventListener("click", refToMain);

function refToMain() {

  window.location.href = "http://127.0.0.1:3000/Final/Main/main.html";
  localStorage.removeItem("userId");

}



