<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
    <title>Dashboard</title>
    <link href="variables.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
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
            <p>Dashboard</p>
        </div>
        <form action="logout">
            <button id="logout-but">Uitloggen</button>
        </form>
    </div>
    <div class="main">
        <h2>Jouw reservaties</h2>
        <div class="items">
            <p>Datum</p>
            <p>Ruimte</p>
            <p>Tijdstip</p>
            <p>Beschrijving</p>
        </div>
        <div class="workspaces">
            <s:iterator value = "reservations">
                <div class="workspace">
                    <p><s:property value="date"/></p>
                    <p><s:property value="getWorkspaceNames(workspaceId)"/></p>
                    <p><s:property value="beginTime +' - '+ endTime"/> </p>
                    <p><s:property value="description"/></p>
                </div>
            </s:iterator>
            <div class="button-wrapper">
                <button class="reserve-button">Reserveren</button>
            </div>
        </div>
    </div>
    </div>
</body>
</html>
