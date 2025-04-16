function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param);
}

document.addEventListener('DOMContentLoaded', () => {
  const kamer = getQueryParam('kamer');
  const ruimte = getQueryParam('ruimte');
  const gebouw = getQueryParam('gebouw');
  const tijd = getQueryParam('tijd');
  const datum = getQueryParam('datum');

  const boekingDiv = document.querySelector('.booking-summary');

  if (boekingDiv) {
    boekingDiv.innerHTML = `
      <p><strong>${datum}</strong> ${tijd || ''}</p>
      <div class="room-card">
        <div>
          <strong>${kamer}</strong><br>
          ${gebouw || ''}<br>
          ${ruimte || ''}
        </div>
      </div>
    `;
  }
});

function filterParticipants() {
  const searchInput = document.getElementById('participant-search').value.toLowerCase();
  const participants = document.querySelectorAll('#participant-list li');
  participants.forEach(participant => {
    if (participant.textContent.toLowerCase().includes(searchInput)) {
      participant.style.display = 'list-item';
    } else {
      participant.style.display = 'none';
    }
  });
}

function handleReservation(event) {
  event.preventDefault(); // Voorkom standaard formulierverzending

  const naam = document.querySelector('input[name="naam"]').value;
  const omschrijving = document.querySelector('input[required][type="text"]').value;
  const aantalDeelnemers = document.querySelector('input[required][type="number"]').value;
  const startTijd = document.getElementById('start-time-input').value;
  const eindTijd = document.getElementById('end-time-input').value;

  const geselecteerdeDeelnemers = [];
  document.querySelectorAll('#participant-list li').forEach(participant => {
    if (participant.style.display !== 'none') {
      geselecteerdeDeelnemers.push(participant.textContent);
    }
  });

  if (!naam || !omschrijving || !aantalDeelnemers || !startTijd || !eindTijd) {
    alert('Vul alle verplichte velden in.');
    return;
  }

  alert(`Reservering bevestigd!\n\nNaam: ${naam}\nOmschrijving: ${omschrijving}\nAantal deelnemers: ${aantalDeelnemers}\nTijd: ${startTijd} - ${eindTijd}\nGeselecteerde deelnemers: ${geselecteerdeDeelnemers.join(', ')}`);

  // Update de kalenderweergave
  const boekingDiv = document.querySelector('.booking-summary');
  if (boekingDiv) {
    boekingDiv.innerHTML = `
      <p><strong>${startTijd} - ${eindTijd}</strong></p>
      <div class="room-card">
        <div>
          <strong>Kamer: 106</strong><br>
          Projectgroep ruimte
        </div>
      </div>
    `;
  }
}

function toggleSubmitButton() {
  const checkbox = document.getElementById('terms-checkbox');
  const submitButton = document.getElementById('submit-button');
  submitButton.disabled = !checkbox.checked;
}