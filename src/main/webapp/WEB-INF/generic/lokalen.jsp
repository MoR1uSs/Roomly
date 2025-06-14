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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/variables.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <script src="${pageContext.request.contextPath}/scripts/filter-reservations.js" defer></script>
  <script src="${pageContext.request.contextPath}/scripts/filter-workspaces.js" defer></script>
  <script type="module" src="${pageContext.request.contextPath}/scripts/reservation-validation.js" defer></script>
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
    <div class="profile">
      <div class="info">
      <p>Lokalen</p>
      </div>
      <form action="logout">
        <button id="logout-but">Uitloggen</button>
      </form>
    </div>
    <div class="overlay"></div>
    <div class="hidden-window">
        <div class="hidden-form">
          <div class="reservations-container">
            <div class="form-layout">
              <h2>Nieuwe locatie reservering</h2>
              <div class="left-panel">
                <s:form action="create-reservation" method="post" theme="simple" class="reservation-form">
                  <label>Locatie:</label>
                  <s:select
                          id="workspace"
                          name="selectedWorkspaceId"
                          list="workspaces"
                          listKey="id"
                          listValue="name"
                          headerKey=""
                          cssClass="workspaces-list"/><br>
                  <label>Date: <input data-date type="date" name="date" required></label>
                  <label>Begintijd: <input data-beginTime type="time" name="beginTime" required></label>
                  <label>Eindtijd: <input data-endTime type="time" name="endTime" required></label>
                  <label for="description">Omschrijving:</label>
                  <s:textfield id="description" name="description"/>
                  <div class="buttons">
                    <input type="button" class="submit-button" value="Annuleren" onclick="hideUpdateScreen()">
                    <p id="error-text"></p>
                    <s:submit value="Reserveren" cssClass="submit-button" id="disabled-button" disabled="false"/>
                  </div>
                </s:form>
              </div>
            </div>
            <div class="right-panel">
                <s:iterator value="reservations">
                  <div class="reservation-wrapper" data-location="<s:property value='getWorkspaceNames(id)'/>">
                    <h3 data-reservation-date><s:property value="parseDate(id)"/></h3>
                    <div class="time">
                      <p data-reservation-time><s:property value="beginTime + ' - ' + endTime"/></p>
                      <i class="fa-regular fa-calendar"></i>
                    </div>
                  </div>
                </s:iterator>
            </div>
            <s:if test="hasActionErrors()">
              <div style="color: red;">
                <s:actionerror/>
              </div>
            </s:if>
          </div>
        </div>
    </div>
    <div class="main">
      <div class="filter">
        <i id="search-icon" class="fa-solid fa-magnifying-glass"></i>
        <input name="term" type="search" id="search" placeholder= "Typ hier..." />
        <select id="dropdown-filters">
          <option value="name">Name</option>
          <option value="capacity">Capacity</option>
          <option value="facilities">Facilities</option>
        </select>
      </div>
      <div class="new-form"></div>
      <div class="items">
        <p>Naam</p>
        <p>Faciliteit</p>
        <p>Locatie</p>
        <p>Capaciteit</p>
        <p>Status</p>
      </div>
      <div class="workspaces">
        <s:iterator value = "workspaces">
          <div class="workspace">
            <h3 data-name='<s:property value="name"/>'><s:property value="name"/></h3>
            <p data-facilities='<s:property value="facilities"/>' ><s:property value="facilities"/></p>
            <p data-location='<s:property value="location"/>'><s:property value="location"/></p>
            <p data-capacity='<s:property value="capacity"/>' class="capacity"><s:property value="capacity"/></p>
            <p data-status='<s:property value="status"/>' class="status"><s:property value="status"/></p>
            <form>
              <button type="button"
                      onclick="showUpdateScreen(<s:property value='id'/>, '<s:property value="name"/>')"
                      class="reserve-button">
                Reserveren
              </button>
            </form>
          </div>
        </s:iterator>
        <div class="button-wrapper">
        </div>
      </div>
    </div>
    <script>
       let status = document.querySelectorAll(".status");

       status.forEach(el => {
          el.style.fontWeight = "800";
          if(el.innerHTML === "Vrij"){
            el.style.color = "rgba(24,202,43,0.66)";
          } else {
            el.style.color = "rgba(255,15,15,0.76)";
          }
       });
    </script>
  </div>
</body>
</html>