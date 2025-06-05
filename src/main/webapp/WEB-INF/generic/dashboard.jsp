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
            <p>Dashboard</p>
        </div>
        <form action="logout">
            <button id="logout-but">Uitloggen</button>
        </form>
    </div>
    <div class="overlay">
        <div class="hidden-window">
            <div class="hidden-form">
                <div class="container">
                    <div class="update-form">
                        <h3>Voer nieuwe tijd in</h3>
                        <s:form action="update-reservation" method="post" theme="simple">
                            <label>Begintijd: <input type="time" name="newBeginTime" required></label>
                            <label>Eindtijd: <input type="time" name="newEndTime" required></label>
                            <div class="buttons">
                                <input type="hidden" name="id" class="reservation-id" />
                                <input type="submit" value="Annuleren" onclick="hideUpdateScreen()">
                                <s:submit value="Bewerken"/>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <s:if test="reservations == null || reservations.isEmpty()">
        <p class="no-reservations-p">Nog geen reservaties</p>
    </s:if>
    <s:else>
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
                            <h4><s:property value="parseDate(id)"/></h4>
                            <p><s:property value="getWorkspaceNames(workspaceId)"/></p>
                            <p><s:property value="beginTime +' - '+ endTime"/> </p>
                            <p><s:property value="description"/></p>
                            <div class="d-u-buttons">
                                <button class="update" onclick="showUpdateScreen(<s:property value='id'/>)">Bewerken</button>
                                <form action="delete-action" method="post">
                                    <input type="hidden" name="id" value="<s:property value='id'/>" />
                                    <s:submit value="Verwijderen" class="delete"/>
                                </form>
                            </div>
                        </div>
                    </s:iterator>
                </s:else>
            </div>
        </div>
    </div>
    <script>
        const element = document.querySelector(".hidden-window");
        const overlay = document.querySelector(".overlay");

        function hideUpdateScreen(){
            overlay.style.display = "none";
            element.style.display = "none";
        }

        function showUpdateScreen(id){
            document.querySelector(".reservation-id").value = id;
            overlay.style.display = "block";
            element.style.display = "block";
        }
    </script>
</body>
</html>
