<%--
  Created by IntelliJ IDEA.
  User: Evgeny
  Date: 20.04.2016
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
    <h1>List: </h1>
    <c:forEach var="listVar" items="${list}">
        Name <c:out value="${listVar.name}"/><p>
    </c:forEach>
</body>
</html>
