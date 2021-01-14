document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    if (this.formValidate()) {
                        this.currentStep++;
                        this.updateForm();
                    }
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;


        }

        formValidate() {


            const toAppend = this.$form.querySelector(".active");
            if (this.currentStep === 1) {
                const categories = this.$form.querySelectorAll("[name=categories]:checked");
                if (categories.length === 0) {
                    toAppend.style = "color:red";
                    toAppend.innerHTML = "Wybierz przynajmniej jedną kategorię";

                    return false;
                } else {
                    return true;
                }
            }
            if (this.currentStep === 2) {

                const bags = this.$form.querySelector("#quantity").value;
                if (bags <= 0) {
                    toAppend.style = "color:red";
                    toAppend.innerHTML = "Podaj ilość worków";

                    return false;

                } else {
                    return true;
                }

            }

            if (this.currentStep === 3) {
                const institution = document.querySelector("[name=institution]:checked");
                console.log(institution);
                if (institution == null) {
                    toAppend.style = "color:red";
                    toAppend.innerHTML = "Wybierz jedną instytucję";

                    return false;
                } else {
                    return true;
                }

            }
            if (this.currentStep === 4) {
                let street = this.$form.querySelector("#street").value;
                let city = this.$form.querySelector("#city").value;
                let zipCode = this.$form.querySelector("#zipCode").value;
                let phoneNumber = this.$form.querySelector("#phone").value;
                let pickUpDate = this.$form.querySelector("#pickUpDate").value;
                let pickUpTime = this.$form.querySelector("#pickUpTime").value;
                let pickUpComment = this.$form.querySelector("#pickUpComment").value;
                const regExpZipCode = new RegExp("^[0-9]{2}-[0-9]{3}");
                const regExpDate = new RegExp("^2\\d{3}-[0-2]\\d-[0-3]\\d");
                const regExpTime = new RegExp("^([01]?\\d|2[0-3]):[0-5]\\d");
                let streetLabel = this.$form.querySelector("#streetLabel");
                let cityLabel = this.$form.querySelector("#cityLabel");
                let zipCodeLabel = this.$form.querySelector("#zipCodeLabel");
                let phoneLabel = this.$form.querySelector("#phoneLabel");
                let pickUpDateLabel = this.$form.querySelector("#pickUpDateLabel");
                let pickUpTimeLabel = this.$form.querySelector("#pickUpTimeLabel");

                let flag = true;

                function testStreet() {
                    if (street.length === 0) {

                        streetLabel.style.color = "red";
                        streetLabel.innerHTML = "Wpisz nazwę ulicy";
                        return false;
                    } else {
                        streetLabel.innerHTML = '';
                        return true;
                    }
                }

                function testCity() {
                    if (city.length === 0) {
                        cityLabel.style.color = "red";
                        cityLabel.innerHTML = "Wpisz nazwę miasta";
                        return false;
                    } else {
                        cityLabel.innerHTML = '';
                        return true;
                    }
                }

                function testZipCode() {
                    if (zipCode.length === 0 || !regExpZipCode.test(zipCode)) {
                        zipCodeLabel.style.color = "red";
                        zipCodeLabel.innerHTML = "Wpisz kod pocztowy";
                        return false;
                    } else {
                        zipCodeLabel.innerHTML = '';
                        return true;
                    }
                }


                function testPhone() {
                    if (phoneNumber.length === 0 || !isCorrectPhoneNumber(phoneNumber)) {
                        phoneLabel.style.color = "red";
                        phoneLabel.innerHTML = "Podaj numer telefonu";
                        return false;
                    } else {
                        phoneLabel.innerHTML = '';
                        return true;
                    }
                }

                function testPickUpDate() {
                    if (pickUpDate.length === 0 || !regExpDate.test(pickUpDate)) {
                        pickUpDateLabel.style.color = "red";
                        pickUpDateLabel.innerHTML = "Musisz podać datę w formacie rrrr-MM-dd np. 2010-07-13";
                        return false;
                    } else {
                        let today = new Date()
                        if (today >= new Date(pickUpDate)) {
                            pickUpDateLabel.style.color = "red";
                            pickUpDateLabel.innerHTML = "Musisz podać datę z przyszłości";
                            return false;
                        } else {
                            pickUpDateLabel.innerHTML = '';
                            return true;
                        }

                    }
                }

                function testPickUpTime() {
                    if (pickUpTime.length === 0 || !regExpTime.test(pickUpTime)) {
                        pickUpTimeLabel.style.color = "red";
                        pickUpTimeLabel.innerHTML = "Musisz podać czas odbioru w formacie HH:mm np. 14:20";
                        return false;
                    } else {
                        pickUpTimeLabel.innerHTML = '';
                        return true;
                    }
                }

                function initializeTests() {
                    testPickUpTime();
                    testPickUpDate();
                    testPhone();
                    testZipCode();
                    testStreet();
                    testCity();

                }

                initializeTests();

                if (testCity() && testStreet() && testZipCode() && testPhone() && testPickUpDate() && testPickUpTime()) {
                    return true;
                } else {
                    return false;
                }
            }


            function isCorrectPhoneNumber(telNumber) {
                const regExpPhoneNumber1 = new RegExp("^([0-9]{3})([\s-]?[0-9]{3}){2}");
                const regExpPhoneNumber2 = new RegExp("^00[0-9]{2}([\s-]?[0-9]{3}){3}");
                const regExpPhoneNumber3 = new RegExp("^\\+[0-9]{2}([\s-]?[0-9]{3}){3}");
                return regExpPhoneNumber1.test(telNumber) || regExpPhoneNumber2.test(telNumber) || regExpPhoneNumber3.test(telNumber);
            }
        }
    }


    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
})
;
