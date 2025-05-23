<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Roomly Registratie</title>
  <link rel="stylesheet" href="CSS/Registeren.css" />
  <link rel="IMGICON" href="IMG/RoomlyHoofd.png" type="image/png" sizes="16x16" />
</head>

<body>
  <div class="container">
    <h1 class="logo">
      <img src="IMG/RoomlyHoofd.png" alt="Roomly Logo" class="logo-img" style="height: 1em; vertical-align: middle;" />
      ROOMLY
    </h1>
    <div class="register-box">
    <h2>Registreren</h2>
      <form action="register" method="post">
        <label for="username">Naam</label>
        <input type="text" id="username" name="username" placeholder="Voer je Naam in" required />

        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Voer je Email in" required />

        <label for="password">Wachtwoord</label>
        <input type="password" id="password" name="password" placeholder="Voer je Wachtwoord in" required />

        <input type="submit" class="register-button" value="Registreren" />
        <p class="login-link">Heb je al een account?<br><a href="login">Log hier in.</a></p>
      </form>
    </div>
  <s:if test="hasActionErrors()">
    <div style="color: red;">
      <s:actionerror/>
    </div>
  </s:if>
  </div>
</body>
</html>