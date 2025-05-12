<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">

<head>
  <meta charset="UTF-8">
  <title>Kamer reserveren</title>
  <link rel="stylesheet" href="style.css">
</head>

<body>
  <div class="container">
    <h2>Nieuwe locatie reservering</h2>

    <div class="form-layout">
      <div class="left-panel">
        <s:form action="reservation-form">
            <s:select
                label="Locatie"
                name="selectedCategoryId"
                list="workspaces"
                listKey="id"
                listValue="name"
                headerKey=""
                headerValue="-- Maak een keuze --" />
            <s:submit value="Submit"/>
        </s:form>
        <h3>Extra informatie</h3>
        <form>
          <label>Korte omschrijving <input type="text" required></label>
          <button type="submit" disabled>Reservering bevestigen</button>
        </form>
      </div>

      <div class="right-panel">
        <div class="booking-summary">
          <p><strong>08 april 2025</strong> 11:15 - 12:15</p>
          <div class="room-card">
            <span class="icon">📍</span>
            <div>
              <strong>106</strong><br>
              <br>
              Projectgroep ruimte
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>