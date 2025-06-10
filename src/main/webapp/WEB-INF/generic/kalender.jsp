<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
  <meta charset="UTF-8">
  <title>Kalender</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/CSS/variables.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.css" rel="stylesheet" />
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.10/index.global.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/kalender.css">
</head>
<body>
<div class="container">
  <div class="nav-bar">
    <h1 class="roomly">Roomly</h1>
    <div class="nav-bar-items">

      <s:if test="checkRole">
        <p onclick="window.location.href = 'admin-dashboard.action'">
          <i class="fa-solid fa-lock-open"></i> Beheerderspaneel
        </p>
      </s:if>

      <p onclick="window.location.href='load-reservations.action'">
        <i class="fa fa-home"></i> Dashboard
      </p>

      <p onclick="window.location.href = 'lokalen.action'">
        <i class="fa fa-list-ol"></i> Lokalen
      </p>
      <p onclick="window.location.href = `kalender.action`">
        <i class="fa fa-calendar-days"></i> Kalender
      </p>
    </div>
  </div>
<div id="calendar"></div>

<script>
  document.addEventListener('DOMContentLoaded', function () {
    const calendarEl = document.getElementById('calendar');

    const calendar = new FullCalendar.Calendar(calendarEl, {
    });

    calendar.render();
  });
</script>

</body>
</html>
