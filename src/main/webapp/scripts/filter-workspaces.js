const workspaces = document.querySelectorAll(".workspace");
const searchInput = document.querySelector("#search");
const filterDropdown = document.querySelector("#dropdown-filters");

if(searchInput && filterDropdown) {
    searchInput.addEventListener("input", (event) => {
        const input = event.target.value.toLowerCase().trim();
        const filter = filterDropdown.value; // current filter value on each input

        workspaces.forEach(workspace => {
            let shouldShow = false;
            const name = workspace.querySelector('[data-name]')?.dataset.name?.toLowerCase() || '';
            const capacity = workspace.querySelector('[data-capacity]')?.dataset.capacity?.toLowerCase() || '';
            const facilities = workspace.querySelector('[data-facilities]')?.dataset.facilities?.toLowerCase() || '';

            if (input === "") {
                workspace.classList.remove("hidden");
                return;
            }

            switch (filter) {
                case "name":
                    shouldShow = name.includes(input);
                    break;
                case "capacity":
                    shouldShow = capacity.includes(input);
                    break;
                case "facilities":
                    shouldShow = facilities.includes(input);
                    break;
            }

            workspace.classList.toggle("hidden", !shouldShow);
        });
    });
}