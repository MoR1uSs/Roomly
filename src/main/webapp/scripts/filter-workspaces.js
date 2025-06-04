const filter = document.querySelector("#dropdown-filters").value;
const workspaces = document.querySelectorAll(".workspace");
const searchInput = document.querySelector("#search");

if(searchInput && filter){
    const filterInput = (elements, filter, input) => {
        elements.forEach(el => {
            const elementValue = el.dataset[filter]?.toLowerCase() || '';

            const shouldShow = elementValue.includes(input);

            el.parentElement.classList.toggle("hidden", !shouldShow);
        })
    }

    searchInput.addEventListener("input", (event) =>{
        const input = event.target.value.toLowerCase();

        if (input.trim() === "") {
            workspaces.forEach(el =>{
                el.classList.remove("hidden");
            })
            return;
        }

        switch (filter) {
            case "name":
                filterInput(document.querySelectorAll("[data-name]"), "name", input);
                break;
            case "capacity":
                filterInput(document.querySelectorAll("[data-capacity]", "capacity", input));
                break;
            case "facilities":
                filterInput(document.querySelectorAll("[data-faciilities]", "facilities", input));
                break;
        }
    })
}