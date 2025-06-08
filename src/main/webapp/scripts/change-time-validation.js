import {disableButton} from "./utils.js";

const form = document.querySelector("#update-reservation-form");
const requiredFields = form.querySelectorAll("input");
const button = document.querySelector("#update-button");
const p = document.querySelector("#error-text");

if(form && requiredFields && button){
    disableButton(p, button, true);

    const checkFields = () => {
        disableButton(p, button, true);

        let newBegTime;
        let newEndTime;

        requiredFields.forEach(field => {
            if(field.hasAttribute("data-newBeginTime")){
                const [hours, minutes] = field.value.split(':').map(Number);
                newBegTime = new Date();
                newBegTime.setHours(hours, minutes, 0, 0);
                return;
            }

            if(field.hasAttribute("data-newEndTime")){
                const [hours, minutes] = field.value.split(':').map(Number);
                newEndTime = new Date();
                newEndTime.setHours(hours, minutes, 0, 0);
            }
        })

        if(newBegTime && !isNaN(newEndTime)){
            console.log(newBegTime)
            console.log(newEndTime)
        }

        if(newBegTime < newEndTime){
            disableButton(p, button, false);
        }
    }

    requiredFields.forEach(field => {
        field.addEventListener("input", checkFields);
    })
}

