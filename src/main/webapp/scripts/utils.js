export function disableButton(p, button, shouldDisable) {
    if (!p || !button) return;  // Safety check

    if (shouldDisable) {
        p.style.color = "red";
        p.style.fontWeight = "600";
        button.disabled = true;
        button.style.background = "#cccccc";
        button.style.opacity = "0.7";
        button.style.cursor = "not-allowed";
    } else {
        p.style.color = "";
        p.style.fontWeight = "";
        button.disabled = false;
        button.style.background = "var(--button-color)";
        button.style.opacity = "1";
        button.style.cursor = "pointer";
    }
}