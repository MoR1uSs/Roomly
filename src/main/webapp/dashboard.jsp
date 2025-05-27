<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
    <title>Dashboard</title><link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link href="variables.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
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
            </div>
        </div>
    </div>
    </div>
</body>
</html>
