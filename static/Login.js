const URL = "http://localhost:8080/static/Login.html";

let loginButton = document.getElementById("loginButton");

loginButton.onClick = login;

function getUserLogin(newUsername, newPassword){
    let newFirstName = "";
    let newLastName = "";
    let newEmail = "";
  
    let credential = {
      ers_users_id:0,
      ers_username:newUsername,
      ers_password:newPassword,
      user_first_name:newFirstName,
      user_last_name:newLastName,
      user_email:newEmail,
      user_role_id:0,
      user_role:""
    }
  
    return credential;
  }

async function login(){
    event.preventDefault();

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let credentials = getUserLogin(username, password);
    let response = await fetch(URL, {
      method:'POST',
      body:JSON.stringify(credentials)
    });
    if (response.status==201){
      deleteLoginForm();
    } else {
      console.log("User login fail");
    }
  }