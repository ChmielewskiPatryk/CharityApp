document.addEventListener('DOMContentLoaded',function() {

let addButton = document.querySelector("#addInstitution");
    let description = document.querySelector("input[name ='description']");
    let name = document.querySelector("input[name='name']");

addButton.addEventListener('click',function (e){
    let descriptionLabel=document.querySelector("#descriptionLabel");
    let nameLabel = document.querySelector("#nameLabel");
    if(!description.value){
        descriptionLabel.innerHTML = "Podaj opis  organizacji";
    } else {
        descriptionLabel.innerHTML = "";

    }
    if(!name.value){
        nameLabel.innerHTML="Podaj nazwę organizacji";
    }
    else {
        nameLabel.innerHTML = "";
    }
    if(!description.value || !name.value){
        e.preventDefault();


    }
})
})