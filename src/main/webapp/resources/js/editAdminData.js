document.addEventListener('DOMContentLoaded', function () {

    let addButton = document.querySelector("#editAdmin");
    let name = document.querySelector("input[name ='name']");
    let lastName = document.querySelector("input[name='lastName']");
    let email = document.querySelector("input[name='email']");

    addButton.addEventListener('click', function (e) {
        let lastNameLabel = document.querySelector("#lastNameLabel");
        let nameLabel = document.querySelector("#nameLabel");
        let emailLabel = document.querySelector("#emailLabel");


        if (!name.value) {
            nameLabel.innerHTML = "Podaj imię administratora";
        } else {
            nameLabel.innerHTML = "";

        }
        if (!lastName.value || lastName.value == "") {
            lastNameLabel.innerHTML = "Podaj nazwisko administratora";
        } else {
            lastNameLabel.innerHTML = "";
        }
        if (!email.value) {
            emailLabel.innerHTML = "Podaj email administratora";
        } else {
            emailLabel.innerHTML = "";
        }

        if (!name.value || !lastName.value || !email.value) {
            e.preventDefault();


        }
    })
})