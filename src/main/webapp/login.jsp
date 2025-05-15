<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="nl">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Roomly Login</title>
  <link rel="stylesheet" href="CSS/Inlog.css" />
  <link rel="IMGICON" href="IMG/RoomlyHoofd.png" type="image/png" sizes="16x16" />
</head>

<body>
  <div class="container">
    <h1 class="logo">
      <img src="IMG/RoomlyHoofd.png" alt="Roomly Logo" class="logo-img" style="height: 1em; vertical-align: middle;" />
      ROOMLY
    </h1>
    <div class="login-box">
    <h2>Inloggen</h2>
    <form action="login" method="post">
      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="@scalda.nl" required />

      <label for="password">Wachtwoord</label>
      <input type="password" id="password" name="password" placeholder="..." required />

      <input type="submit" class="login-button" value="Inloggen" />

      <p class="register-link">Nog geen account?<br><a href="/Reservatiesysteem/">Registreer je hier.</a></p>
    </form>
    </div>
  </div>
  <s:if test="hasActionErrors()">
    <div style="color: red;">
      <s:actionerror/>
    </div>
  </s:if>
</body>
</html>