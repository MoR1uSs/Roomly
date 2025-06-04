const locationDropdown = document.querySelector(".workspaces-list");
const reservations = document.querySelectorAll(".reservation-wrapper");

locationDropdown.addEventListener("change", (event) => {
    if(locationDropdown && reservations) {
        const currentLocation = event.target.options[event.target.selectedIndex].text;

        const filterItems = () => {
            if(currentLocation == "-- Maak een keuze --"){
                let p = document.createElement("p")
                p.innerHTML = "Geen reservaties";

            }

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

