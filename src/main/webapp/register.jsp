<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registratie</title>
</head>
<body>
    <h2>Registratie</h2>

    <s:if test="hasActionErrors()">
        <div style="color: red;">
            <s:actionerror/>
        </div>
    </s:if>

    <form action="register" method="post">
        <div>
            <label for="username">Kies een gebruikersnaam:</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email">
        </div>
        <div>
            <label for="password">Kies een wachtwoord:</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <input type="submit" value="Registreren">
        </div>
    </form>

    <p>Al een account? <a href="/login">Inloggen</a></p>
</body>
</html>