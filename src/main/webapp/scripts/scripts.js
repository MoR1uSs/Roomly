document.querySelector("#search").addEventListener("input", (event) =>{
    let input = event.target.value.toLowerCase();
    let filter = document.querySelector("#dropdown-filters").value;
    let workspaces = document.querySelectorAll(".workspace");

    if (input.trim() === "") {
        workspaces.forEach(el =>{
            el.classList.remove("hidden");
        })
        return;
    }

    if(filter === "name"){
        let elements = document.querySelectorAll("[data-name]");

        elements.forEach(el => {
            let name = el.dataset.name.toLowerCase();

            if (name.includes(input)) {
                el.parentElement.classList.remove("hidden")
            } else {
                el.parentElement.classList.add("hidden");
            }
        });
    }

    if(filter === "capacity"){
        let elements = document.querySelectorAll("[data-capacity]");

        elements.forEach(el => {
            let capacity = el.dataset.capacity;

            if (capacity.includes(input)) {
                el.parentElement.classList.remove("hidden")
            } else {
                el.parentElement.classList.add("hidden");
            }
        });
    }

    if(filter === "facilities"){
        let elements = document.querySelectorAll("[data-facilities]");

        elements.forEach(el => {
            let name = el.dataset.facilities.toLowerCase();

            if (name.includes(input)) {
                el.parentElement.classList.remove("hidden")
            } else {
                el.parentElement.classList.add("hidden");
            }
        });
    }
})