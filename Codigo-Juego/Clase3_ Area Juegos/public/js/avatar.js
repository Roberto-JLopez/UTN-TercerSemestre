 function seleccionarPersonajeJugador() {
    if (document.getElementById('Zuko').checked) {
        alert("HAS SELECCIONADO A ZUKO 🔥");
    } else if (document.getElementById('Katara').checked) {
        alert("HAS SELECCIONADO A KATARA 💧");
    } else if (document.getElementById('Aang').checked) {
        alert("HAS SELECCIONADO A AANG 🌪️");
    } else if (document.getElementById('Toph').checked) {
        alert("HAS SELECCIONADO A TOPH 🌱");
    } else if (document.getElementById('Sokka').checked) {
        alert("HAS SELECCIONADO A SOKKA ⚔️");
    } else {
        alert("Por favor, selecciona un personaje antes de continuar.");
    }
}

let botonPersonajeJugador = document.getElementById("boton-personaje");

botonPersonajeJugador.addEventListener("click", seleccionarPersonajeJugador);