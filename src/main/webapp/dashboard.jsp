<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Roomly Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 30px;
        }

        .search-bar {
            margin: 20px auto;
            width: 60%;
        }

        .rooms-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .room-card {
            width: 150px;
            height: 100px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            text-align: center;
            background-color: #f0f0f0;
        }

        .logout-btn {
            padding: 5px 10px;
        }

        .status-vrij {
            color: green;
            font-weight: bold;
        }

        .status-bezet {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>Roomly</h1>
    <form action="logout.action" method="post">
        <input class="logout-btn" type="submit" value="Afmelden"/>
    </form>
</div>

<div class="search-bar">
    <form action="roomList.action" method="get">
        <input type="text" name="searchTerm" placeholder="Zoeken...">
        <input type="submit" value="Search">
    </form>
</div>

<div class="rooms-grid">
    <s:iterator value="workspaces">
        <div class="room-card">
            <div><strong>Lokaal <s:property value="name"/></strong></div>
            <div class="<s:property value='occupied == 0 ? \"status-vrij\" : \"status-bezet\"'/>">
                <s:property value="occupied == 0 ? 'Vrij' : 'Bezet'"/>
            </div>
            <div><s:property value="occupied"/>/<s:property value="capacity"/></div>
        </div>
    </s:iterator>
</div>

</body>
</html>
