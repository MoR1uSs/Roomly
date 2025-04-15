<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Список помещений</title>
</head>
<body>
    <h1>Список помещений</h1>
    <ul>
        <s:iterator value="workspaces">
            <li><s:property value="name"/> - <s:property value="location"/></li>
        </s:iterator>
    </ul>
</body>
</html>
