<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Lokalen</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="style.css" />
  <link rel="stylesheet" href="variables.css">
  <script src="scripts.js" defer></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
  <div class="container">
    <div class="nav-bar">
      <h1 class="roomly">Roomly</h1>
      <div class="nav-bar-items">
        <p onclick="window.location.href='load-reservations.action'">
          <i class="fa fa-home"></i> Dashboard
        </p>
        <p onclick="window.location.href = 'lokalen.action'">
          <i class="fa fa-list-ol"></i> Lokalen
        </p>
        <p>
          <i class="fa fa-calendar-days"></i> Kalender
        </p>
      </div>
    </div>
    <div class="profile">
      <div class="info">
      <p>Lokalen</p>
      </div>
      <form action="logout">
        <button id="logout-but">Uitloggen</button>
      </form>
    </div>
    <div class="main">
      <div class="filter">
        <i id="search-icon" class="fa-solid fa-magnifying-glass"></i>
        <input name="term" type="search" id="search" placeholder= "Typ hier..." />
        <select id="dropdown-filters" name="filters">
          <option value="name">Naam</option>
          <option value="facilities">Faciliteit</option>
          <option value="capacity">Capaciteit</option>
         <!-- <option value="status">Status</option>
          <option value="location">Locatie</option>-->
        </select>
      </div>
      <div class="new-form"></div>
      <div class="items">
        <p>Naam</p>
        <p>Capaciteit</p>
        <p>Faciliteit</p>
        <p>Locatie</p>
        <p>Status</p>
      </div>
      <div class="workspaces">
        <s:iterator value = "workspaces">
          <div class="workspace">
            <h2 data-name='<s:property value="name"/>'><s:property value="name"/></h2>
            <p data-capacity='<s:property value="capacity"/>' class="capacity"><s:property value="capacity"/></p>
            <p data-facilities='<s:property value="facilities"/>' ><s:property value="facilities"/></p>
            <p data-location='<s:property value="location"/>'><s:property value="location"/></p>
            <p data-status='<s:property value="status"/>' class="status"><s:property value="status"/></p>
          </div>
        </s:iterator>
        <div class="button-wrapper">
          <form action="reservation-form">
            <button class="reserve-button">Reserveren</button>
          </form>
        </div>
      </div>
    </div>
    <script>
       let status = document.querySelectorAll(".status");

       status.forEach(el => {
          el.style.fontWeight = "800";
          el.style.opacity = 1;
          if(el.innerHTML == "Vrij"){
            el.style.color = "rgba(24,202,43,0.66)";
          } else {
            el.style.color = "rgba(255,15,15,0.76)";
          }
       });
    </script>
  </div>
</body>
</html>