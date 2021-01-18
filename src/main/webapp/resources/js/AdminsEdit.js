document.addEventListener('DOMContentLoaded',function() {

  let addButton = document.querySelector("#addAdmin");
  let name = document.querySelector("input[name ='name']");
  let lastName = document.querySelector("input[name='lastName']");
  let email = document.querySelector("input[name='email']");
  let password = document.querySelector("input[name='password']");
  let retypePassword = document.querySelector("input[name='retypePassword']");

  addButton.addEventListener('click',function (e){
    let lastNameLabel=document.querySelector("#lastNameLabel");
    let nameLabel = document.querySelector("#nameLabel");
    let emailLabel = document.querySelector("#emailLabel");
    let passwordLabel = document.querySelector("#passwordLabel");
    let retypePasswordLabel = document.querySelector("#retypePasswordLabel");

    if(!name.value){
      nameLabel.innerHTML = "Podaj imię administratora";
    } else {
      nameLabel.innerHTML = "";

    }
    if(!lastName.value){
      lastNameLabel.innerHTML="Podaj nazwisko administratora";
    }
    else {
      lastNameLabel.innerHTML = "";
    }
    if(!email.value){
      emailLabel.innerHTML="Podaj email administratora";
    }
    else {
      emailLabel.innerHTML = "";
    }
    if(!password.value){
      passwordLabel.innerHTML="Podaj hasło";
    }
    else if (password.value != retypePassword.value){
      passwordLabel.innerHTML ="Hasła nie są identyczne"

    }else {
      passwordLabel.innerHTML = "";
    }
    if(!retypePassword.value){
      retypePasswordLabel.innerHTML="Powtórz hasło";
    }
    else {
      retypePasswordLabel.innerHTML = "";
    }
    if(!name.value || !lastName.value || !email.value || !password.value || !retypePassword.value){
      e.preventDefault();


    }
  })
})