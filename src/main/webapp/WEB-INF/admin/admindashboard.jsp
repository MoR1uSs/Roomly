<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
  <title>Dashboard</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/CSS/variables.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
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
      <p>
        <i class="fa fa-calendar-days"></i> Kalender
      </p>
    </div>
  </div>
  <div class="profile">
    <div class="info">
      <p>Beheerderspaneel</p>
    </div>
    <form action="logout">
      <button id="logout-but">Uitloggen</button>
    </form>
  </div>
  <div class="hidden-window">
    <form class="hidden-form">
      <div class="container">
        <div class="update-form">
          <h3>Voer nieuwe tijd in</h3>
          <s:form action="update-reservation" method="post" theme="simple">
            <label>Begintijd: <input type="time" name="beginTime" required></label>
            <label>Eindtijd: <input type="time" name="endTime" required></label>
            <div class="buttons">
              <button type="button" onclick="hideUpdateScreen()">Annuleren</button>
              <s:submit value="Bewerken" cssClass="submit-button"/>
            </div>
          </s:form>
        </div>
      </div>
    </form>
  </div>
  <div class="main">
    <h2>Jouw reservaties</h2>
    <div class="items">
      <p>Naam</p>
      <p>Datum</p>
      <p>Ruimte</p>
      <p>Tijdstip</p>
      <p>Beschrijving</p>
    </div>
    <div class="workspaces">
      <s:iterator value = "reservations">
        <div class="workspace">
          <p class="user-name"><s:property value="getUsername(id)"/></p>
          <p><s:property value="parseDate(id)"/></p>
          <p><s:property value="getWorkspaceNames(workspaceId)"/></p>
          <p><s:property value="beginTime +' - '+ endTime"/> </p>
          <p><s:property value="description"/></p>
          <div class="d-u-buttons">
            <form action="delete-action">
              <input type="hidden" name="id" value="<s:property value='id'/>" />
              <button class="delete" type="submit">Verwijderen</button>
            </form>
          </div>
        </div>
      </s:iterator>
    </div>
  </div>
</div>
<script>
  const element = document.querySelector(".hidden-window");

  function hideUpdateScreen(){
    element.style.display = "none";
  }

  function showUpdateScreen(){
    element.style.display = "block";
  }
</script>
</body>
</html>
