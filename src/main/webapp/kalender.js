document.addEventListener('DOMContentLoaded', function() {
    fetch('reserveringen')
        .then(response => response.json())
        .then(data => {
            let calendarEl = document.getElementById('calendar');
            let calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'timeGridWeek',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                },
                events: data.map(r => ({
                    title: `${r.gebruiker} - ${r.ruimte}`,
                    start: `${r.datum}T${r.tijd}`,
                    description: `Capaciteit: ${r.capaciteit}`
                })),
                eventClick: function(info) {
                    alert(`Details:\n${info.event.title}\n${info.event.start.toLocaleString()}\n${info.event.extendedProps.description}`);
                }
            });
            calendar.render();
        })
        .catch(error => console.error('Error:', error));
});
