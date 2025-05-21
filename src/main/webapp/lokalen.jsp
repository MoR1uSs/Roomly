<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Main</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="style.css" />
</head>
<body>
  <div class="container">
    <div class="nav-bar">
      <h1 class="roomly">Roomly</h1>
      <div class="nav-bar-items">
        <p>Dashboard</p>
        <p>Lokalen</p>
        <p>Kalender</p>
      </div>
    </div>
    <div class="profile">
      <div class="info">
      <p>Lokalen</p>
      </div>
      <button>Uitloggen</button>
    </div>
    <div class="main">
      <div class="filter">
        <form action="#">
          <input type="text" id="search" placeholder="Typ hier..." />
        </form>
      </div>
      <div class="items">
        <p>Naam</p>
        <p>Capaciteit</p>
        <p>Faciliteiten</p>
        <p>Locatie</p>
        <p>Status</p>
      </div>
      <div class="workspaces">
        <s:iterator value = "workspaces">
          <div class="workspace">
            <h2><s:property value="name"/></h2>
            <p class="capacity"><s:property value="capacity"/></p>
            <p><s:property value="facilities"/></p>
            <p><s:property value="location"/></p>
            <p class="status"><s:property value="status"/></p>
          </div>
        </s:iterator>
        <div class="button-wrapper">
          <button class="reserve-button">Reserveren</button>
        </div>
      </div>
    </div>
  <script>
     let elements = document.querySelectorAll(".status");

     elements.forEach(el => {
        if(el.innerHTML == "Vrij"){
          el.style.width = "25px";
          el.style.height= "20px";
          el.style.color = "black";
          el.style.padding = "5px";
          el.style.backgroundColor = "#78d68096";
          el.style.border = "2px green solid";
          el.style.borderRadius = "4px";
        } else {

          el.style.width = "40px";
          el.style.height= "20px";
          el.style.color = "black";
          el.style.padding = "5px";
          el.style.backgroundColor = "#e6898996";
          el.style.border = "2px red solid";
          el.style.borderRadius = "4px";
        }
     });
  </script>
  </div>
</body>
</html>