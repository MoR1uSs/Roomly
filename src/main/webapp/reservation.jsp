<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">

<head>
  <meta charset="UTF-8">
  <title>Kamer reserveren</title>
  <link rel="stylesheet" href="CSS/Reservation.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>

<body>
  <div class="container">
    <h2>Nieuwe locatie reservering</h2>

    <div class="form-layout">
      <div class="left-panel">
            <s:form action="create-reservation" method="post" theme="simple">
                <label>Locatie:</label>
                <s:select
                    id="workspace"
                    name="selectedWorkspaceId"
                    list="workspaces"
                    listKey="id"
                    listValue="name"
                    headerKey=""
                    cssClass="workspaces"
                    headerValue="-- Maak een keuze --" />
                <label>Date: <input type="date" name="date" required></label>
                <label>Begintijd: <input type="time" name="beginTime" required></label>
                <label>Eindtijd: <input type="time" name="endTime" required></label>
                <label for="description">Omschrijving:</label>
                <s:textfield id="description" name="description"/>
                <s:submit value="Reserveren" cssClass="submit-button"/>
            </s:form>
      </div>

      <div class="right-panel">
        <div class="booking-summary">
          <div class="room-card">
            <div>
             <p><strong>08 april 2025</strong> 11:15 - 12:15</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>