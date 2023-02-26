let signupBtn = document.getElementById("signupBtn");
let loginBtn = document.getElementById("loginBtn");

let myName = document.getElementById("name2");
let mySurname = document.getElementById("surname2");
let myEmail = document.getElementById("email");
let error = document.getElementById("error");

let loginEmail = document.getElementById("loginEmail");
let loginPassword = document.getElementById("loginPassword");
let loginName = document.getElementById("loginName");
let errorLogin = document.getElementById("errorLogin");


signupBtn.addEventListener("click", saveData);
loginBtn.addEventListener("click", loginData);



async function fetchUser() {

  let flag = true;
  await fetch("http://localhost:8090/user")
    .then(res => res.json())
    .then(data => {
      for (let i = 0; i < data.length && flag; i++) {

        if (data[i].email === myEmail.value) {
          error.textContent = "User already exists";
          error.style.visibility = "visible";
          flag = false;
        }
        else if (data[i].name === myName.value) {
          error.textContent = "User already exists";
          error.style.visibility = "visible";
          flag = false;
        }
        else if (data[i].surname === mySurname.value) {
          error.textContent = "User already exists";
          error.style.visibility = "visible";
          flag = false;
        }
      }
      return flag
    })
  return flag
}

function saveData(e) {

  e.preventDefault();
  
  fetchUser()
    .then(exist => {

      if (exist) {
        fetch("http://localhost:8090/user/post", {
          method: "POST",
          headers: {
            "Content-type": "application/json",
            "Access-Control-Allow-Origin": "http://127.0.0.1:3000"
          },
          body: JSON.stringify({
            name: myName.value,
            surname: mySurname.value,
            email: myEmail.value
          })
        })

        .then(res => res.json())
        .then(data =>{

            // if (res.status == 200) {

              const nameSurname = {
                "name": myName.value,
                "surname": mySurname.value
              }

              localStorage.setItem("namesSurnames", JSON.stringify(nameSurname));
              localStorage.setItem("userId", data.id);

              
              window.location.href = "http://127.0.0.1:3000/Assignment/ToDoApp/addToDo.html"
            

            
          })
          

      }
    })
}

// function loginData(e) {

//   e.preventDefault();

//   let flag = true;

//   fetch("http://localhost:8090/api/auth/login")
//     .then(res => res.json())
//     .then(data => {

//       for (let i = 0; i < data.length && flag; i++) {

//         if (data[i].name === loginName.value && data[i].surname === loginSurname.value) {

//           flag = false;

//           const nameSurname = {
//             email: loginName.value,
//             password: loginSurname.value
//           }
//           localStorage.setItem("namesSurnames", JSON.stringify(nameSurname));
//           localStorage.setItem("userId", data[i].id);

//           window.location.href = "http://127.0.0.1:3000/Assignment/ToDoApp/addToDo.html"
//         }
//       }
//       if (flag) {
//         errorLogin.textContent = "User not found";
//         errorLogin.style.visibility = "visible";
//       }
//       return flag
//     })
// }

function loginData(e) {

  e.preventDefault();

  let myToken = "";

fetch(`http://localhost:8090/api/auth/login`, {

            method: `POST`,
            headers: {

                'Content-Type': 'application/json',
            },

            body: JSON.stringify({ name: loginName.value, email: loginEmail.value, password: loginPassword.value})


        })
        .then(res => {
          myToken = res.headers.get("Authorization");
          
          if(res.status == 200){

        res.json()
          .then(user => {

            console.log(user);
                      
            const userInfo = {

              name: loginName.value,
            email: loginEmail.value
            
          }

          localStorage.setItem("userInfo", JSON.stringify(userInfo));

          localStorage.setItem("userId", user.id);

          localStorage.setItem("token", myToken)
          
          window.location.href = "http://127.0.0.1:3000/Assignment/ToDoApp/addToDo.html"

        })
      }
      else{
                errorLogin.textContent = "User not found";
        errorLogin.style.visibility = "visible";
      }
        })
      }



