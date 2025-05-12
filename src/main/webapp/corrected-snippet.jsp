<%@ taglib prefix="s" uri="/struts-tags" %>
…
<s:form action="create-reservation" method="post" theme="simple" cssClass="form-layout">
  <!-- Dropdown -->
  <label for="workspace">Locatie:</label>
  <s:select
      id="workspace"
      name="selectedWorkspaceId"
      list="workspaces"
      listKey="id"
      listValue="name"
      headerKey=""
      headerValue="-- Maak een keuze --"
      cssClass="workspaces" />

  <!-- Date -->
  <label for="date">Date:</label>
  <s:textfield id="date" name="date" type="date" required="true"/>

  <!-- Time -->
  <label for="time">Tijd:</label>
  <s:textfield id="time" name="time" type="time" required="true"/>

  <!-- Description -->
  <label for="description">Omschrijving:</label>
  <s:textfield id="description" name="description" required="true"/>

  <!-- Submit -->
  <s:submit value="Reserveren" cssClass="submit-button"/>
</s:form>
