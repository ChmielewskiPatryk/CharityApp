document.addEventListener('DOMContentLoaded',function(){

    document.getElementById("finishButton").addEventListener("click", function(){
        let bags = document.querySelector('input[name="quantity"]');
        let institution = document.querySelector('input[name="institution"]:checked');
        let address = document.querySelector('input[name="street"]');
        let city = document.querySelector('input[name="city"]');
        let postcode = document.querySelector('input[name="zipCode"]');
        let phone = document.querySelector('input[name="phone"]');
        let date = document.querySelector('input[name="pickUpDate"]');
        let time = document.querySelector('input[name="pickUpTime"]');
        let more_info = document.querySelector("textarea");
        let bagsConfirmed = document.querySelector("#confirmedBags");
        let institutionConfirmed = document.querySelector("#confirmedOrganization");
        let formConfirmSection = document.querySelector(".summary").getElementsByTagName("li");
        let confirmedArray = [bags,institution,address, city, postcode, phone, date, time, more_info];
        console.log(bags);
        bagsConfirmed.innerHTML = bags.value;
        institutionConfirmed.innerHTML = institution.value;
        let i;
        for (i = 2;i < 9; i ++){
            formConfirmSection[i].innerHTML = confirmedArray[i].value;
        }
    })
})