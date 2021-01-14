document.addEventListener('DOMContentLoaded',function(){

    document.getElementById("finishButton").addEventListener("click", function(){
        let bags = document.querySelector('input[name="quantity"]').value;
        let categories  = document.querySelectorAll('input[name="categories"]:checked');
        let institution = document.querySelector('input[name="institution"]:checked').getAttribute('description');
        let address = document.querySelector('input[name="street"]').value;
        let city = document.querySelector('input[name="city"]').value;
        let postcode = document.querySelector('input[name="zipCode"]').value;
        let phone = document.querySelector('input[name="phone"]').value;
        let date = document.querySelector('input[name="pickUpDate"]').value;
        let time = document.querySelector('input[name="pickUpTime"]').value;
        let more_info = document.querySelector("textarea").value;
        let bagsConfirmed = document.querySelector("#confirmedBags");
        let institutionConfirmed = document.querySelector("#confirmedOrganization");
        let formConfirmSection = document.querySelector(".summary").getElementsByTagName("li");
        let confirmedArray = [bags,institution,address, city, postcode, phone, date, time, more_info];
        let categoriesString="";

        for(let i= 0; i<categories.length;i++){

            if(i == categories.length-1){
                categoriesString +=categories[i].getAttribute("description");
            }else {
                categoriesString +=categories[i].getAttribute('description')+"; ";
            }

        }
        console.log(confirmedArray);
        console.log(institution);
        console.log(bags);
        bagsConfirmed.innerHTML = bags+" worki;   "+categoriesString;


        institutionConfirmed.innerHTML = institution;
        let i;
        for (i = 2;i < 9; i ++){
            formConfirmSection[i].innerHTML = confirmedArray[i];
        }
    })
})