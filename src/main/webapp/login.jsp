<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inloggen</title>
</head>
<body>
    <h2>Inloggen</h2>

    <s:if test="hasActionErrors()">
        <div style="color: red;">
            <s:actionerror/>
        </div>
    </s:if>

    <form action="login" method="post">
        <div>
            <label for="username">Gebruikersnaam:</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">Wachtwoord:</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <input type="submit" value="Inloggen">
        </div>
    </form>

    <p>Nog geen account? <a href="/register.jsp">Registreren</a></p>
</body>
</html>