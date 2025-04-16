function formatDutchDate(date) {
    const dagen = ['zo', 'ma', 'di', 'wo', 'do', 'vr', 'za'];
    const maanden = ['jan', 'feb', 'mrt', 'apr', 'mei', 'jun', 'jul', 'aug', 'sep', 'okt', 'nov', 'dec'];
    const dagNaam = dagen[date.getDay()];
    const dag = date.getDate();
    const maand = maanden[date.getMonth()];
    const jaar = date.getFullYear();
    return `${dagNaam} ${dag} ${maand} ${jaar}`;
}

function updateDateDisplay(date) {
    const label = document.querySelector('.date-label');
    const dateInput = document.getElementById('date-input');
    label.textContent = formatDutchDate(date);
    dateInput.value = date.toISOString().split('T')[0];
}

function addReservation(roomId, startHour, endHour, title) {
    const room = document.getElementById(roomId);
    if (!room) {
        console.warn(`Room with ID ${roomId} not found.`);
        return;
    }

    const block = document.createElement('div');
    block.className = 'reservation-block';
    block.textContent = title;

    const startOffset = (startHour - 8) * 60;
    const duration = (endHour - startHour) * 60;

    block.style.position = 'absolute';
    block.style.top = `${startOffset}px`;
    block.style.height = `${duration}px`;
    block.style.left = '0';
    block.style.right = '0';
    block.style.backgroundColor = '#4CAF50';
    block.style.color = 'white';
    block.style.padding = '5px';
    block.style.fontSize = '12px';
    block.style.borderRadius = '4px';

    room.appendChild(block);
}

document.addEventListener('DOMContentLoaded', () => {
    let currentDate = new Date();

    updateDateDisplay(currentDate);

    const dateInput = document.getElementById('date-input');
    const prevBtn = document.getElementById('prev-day');
    const nextBtn = document.getElementById('next-day');

    dateInput.addEventListener('change', () => {
        currentDate = new Date(dateInput.value);
        updateDateDisplay(currentDate);
    });

    prevBtn.addEventListener('click', () => {
        currentDate.setDate(currentDate.getDate() - 1);
        updateDateDisplay(currentDate);
    });

    nextBtn.addEventListener('click', () => {
        currentDate.setDate(currentDate.getDate() + 1);
        updateDateDisplay(currentDate);
    });

    fetch('/api/reservaties')
        .then(res => {
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            return res.json();
        })
        .then(data => {
            data.forEach(r => {
                const roomId = `room-${r.kamer}`;
                addReservation(roomId, r.van, r.tot, r.titel);
            });
        })
        .catch(error => {
            console.error('Error fetching reservations:', error);
        });
});