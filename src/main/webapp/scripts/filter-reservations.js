const element = document.querySelector(".hidden-window");
const overlay = document.querySelector(".overlay");

function hideUpdateScreen(){
    overlay.style.display = "none";
    element.style.display = "none";
}

const locationDropdown = document.querySelector(".workspaces-list");
const reservations = document.querySelectorAll(".reservation-wrapper");

function showUpdateScreen(workspaceId, name){
    overlay.style.display = "block";
    element.style.display = "block";

    if(locationDropdown){
        for (let i = 0; i < locationDropdown.options.length; i++){
            if(locationDropdown.options[i].text === name){
                locationDropdown.selectedIndex = i;
                locationDropdown.dispatchEvent(new Event('change')); // Trigger change event
                break;
            }
        }
    }
}

locationDropdown.addEventListener("change", (event) => {
    if(locationDropdown && reservations) {
        const currentLocation = event.target.options[event.target.selectedIndex].text;

        const filterItems = () => {
            reservations.forEach(reservation => {
                if(reservation.dataset["location"] === currentLocation.trim()){
                    reservation.style.display = "block";
                } else {
                    reservation.style.display = "none";
                }
            })
        }

        filterItems();
    }
});

