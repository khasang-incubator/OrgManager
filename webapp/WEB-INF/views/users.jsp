<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

<c:forEach items="${list}" var="allnames">
    <c:out value="${allnames.name} " ></c:out>
</c:forEach>

</body>
</html>
