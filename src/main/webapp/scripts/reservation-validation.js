import { disableButton } from "./utils.js";

const form = document.querySelector(".reservation-form");
const button = document.querySelector("#disabled-button");
const requiredFields = form.querySelectorAll('input[required], select[required]');
const p = document.querySelector("#error-text");

disableButton(p, button, true)
if(form && button && requiredFields){
    const checkRequiredFields = () => {
        p.textContent = "";
        disableButton(p, button, true);

        let isValid = true;
        let today = new Date();
        let selectedDate;
        let selectedBeginTime;
        let selectedEndTime;

        requiredFields.forEach(field => {
            if(!field.value.trim()){
                isValid = false;
            }

            if(field.hasAttribute('data-date')){
                selectedDate = new Date(field.value);

                const currentTime = new Date(today);
                currentTime.setHours(0,0,0,0)

                if (selectedDate < currentTime) {
                    isValid = false;
                    p.textContent = "Voer huidige date in";
                }
            }

            if(field.hasAttribute('data-beginTime')){
                const [hours, minutes] = field.value.split(':').map(Number);

                selectedBeginTime = new Date(selectedDate.getFullYear(), selectedDate.getMonth(), selectedDate.getDate(), hours, minutes);
                let currentTime = new Date(today.getFullYear(), today.getMonth(), today.getDate(), today.getHours(), today.getMinutes());

                if(selectedBeginTime < currentTime){
                    p.textContent = "Voer huidige tijd in";
                    isValid = false;
                }
            }

            if(field.hasAttribute('data-endTime')){
                const [hours, minutes] = field.value.split(':').map(Number);

                selectedEndTime = new Date(selectedDate.getFullYear(), selectedDate.getMonth(), selectedDate.getDate(), hours, minutes);

                if(selectedBeginTime > selectedEndTime){
                    p.textContent = "Voer huidige tijd in";
                    isValid = false;
                }
            }
        });

        if(isValid){
            disableButton(p, button,false);
            return isValid;
        }
    }

    requiredFields.forEach(field => {
        field.addEventListener("input", checkRequiredFields);
    })
}
