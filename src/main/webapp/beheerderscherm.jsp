<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Dashboard</title>
  <link rel="stylesheet" href="CSS/BeheerderScherm.css" />
</head>
<body>
  <div class="sidebar">
    <div class="logo">
      <img src="IMG/RoomlyHoofd.png" alt="Dashboard Logo" style="height: 1.5em; vertical-align: middle; margin-right: 10px;" />
      Roomly
    </div>
    <ul>
      <li class="active">Dashboard</li>
      <li>Berichten</li>
      <li>Activiteit</li>
      <li>Profiel</li>
    </ul>
  </div>

  <div class="main">
      <div class="box">
        <div class="dropdown-filter-wrapper">
          <h2>Op dit moment (Overzicht van ruimtes)</h2>
          <select id="status-filter" onchange="filterRooms(this.value)">
            <option value="all">Alle</option>
            <option value="vrij">Vrij</option>
            <option value="bezet">Bezet</option>
          </select>
        </div>
        <ul id="room-list">
             <s:iterator value="workspaces">
               <div class="room-card">
                 <li data-status="<s:property value='status == 0 ? "vrij" : "bezet"'/>">
                   <strong>Lokaal <s:property value="name"/></strong><br/>
                   Capacity: <s:property value="capacity"/><br/>
                   Facilities: <s:property value="facilities"/><br/>
                   Location: <s:property value="location"/><br/>
                 </li>
               </div>
             </s:iterator>
        </ul>
      </div>
    </div>
  </div>
  <script>
    function filterRooms(status) {
      const rooms = document.querySelectorAll('#room-list li');
      rooms.forEach(room => {
        const roomStatus = room.getAttribute('data-status');
        if (status === 'all' || roomStatus === status) {
          room.style.display = 'list-item';
        } else {
          room.style.display = 'none';
        }
      });
    }
  </script>

</body>
</html>
